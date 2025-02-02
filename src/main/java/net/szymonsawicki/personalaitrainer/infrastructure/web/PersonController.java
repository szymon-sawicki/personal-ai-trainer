package net.szymonsawicki.personalaitrainer.infrastructure.web;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;
import net.szymonsawicki.personalaitrainer.application.service.PersonService;
import net.szymonsawicki.personalaitrainer.domain.dto.PersonCreateDto;
import net.szymonsawicki.personalaitrainer.domain.dto.PersonDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/persons")
@RequiredArgsConstructor
@Tag(name = "Person Controller", description = "Endpoints for managing persons")
public class PersonController {
  private final PersonService personService;

  @PostMapping
  @Operation(summary = "Create a new person")
  @ApiResponses(
      value = {
        @ApiResponse(responseCode = "201", description = "Person created successfully"),
        @ApiResponse(responseCode = "400", description = "Invalid input data")
      })
  public ResponseEntity<
          net.szymonsawicki.personalaitrainer.infrastructure.web.common.ApiResponse<PersonDto>>
      createPerson(@Valid @RequestBody PersonCreateDto personDto) {
    PersonDto created = personService.createPerson(personDto);
    return ResponseEntity.status(HttpStatus.CREATED)
        .body(
            net.szymonsawicki.personalaitrainer.infrastructure.web.common.ApiResponse.of(
                "Person created successfully", created));
  }

  @GetMapping("/{id}")
  @Operation(summary = "Get person by ID")
  @ApiResponses(
      value = {
        @ApiResponse(responseCode = "200", description = "Person found"),
        @ApiResponse(responseCode = "404", description = "Person not found")
      })
  public ResponseEntity<
          net.szymonsawicki.personalaitrainer.infrastructure.web.common.ApiResponse<PersonDto>>
      getPerson(@Parameter(description = "Person ID") @PathVariable(name = "id") Long id) {
    PersonDto person = personService.getPersonById(id);
    return ResponseEntity.ok(
        net.szymonsawicki.personalaitrainer.infrastructure.web.common.ApiResponse.of(
            "Person retrieved successfully", person));
  }

  @GetMapping
  @Operation(summary = "Get all persons")
  public ResponseEntity<
          net.szymonsawicki.personalaitrainer.infrastructure.web.common.ApiResponse<
              List<PersonDto>>>
      getAllPersons() {
    List<PersonDto> persons = personService.getAllPersons();
    return ResponseEntity.ok(
        net.szymonsawicki.personalaitrainer.infrastructure.web.common.ApiResponse.of(
            "Persons retrieved successfully", persons));
  }

  @PutMapping("/{id}")
  @Operation(summary = "Update person by ID")
  @ApiResponses(
      value = {
        @ApiResponse(responseCode = "200", description = "Person updated successfully"),
        @ApiResponse(responseCode = "404", description = "Person not found"),
        @ApiResponse(responseCode = "400", description = "Invalid input data")
      })
  public ResponseEntity<
          net.szymonsawicki.personalaitrainer.infrastructure.web.common.ApiResponse<PersonDto>>
      updatePerson(
          @Parameter(description = "Person ID") @PathVariable(name = "id") Long id,
          @Valid @RequestBody PersonCreateDto personDto) {
    PersonDto updated = personService.updatePerson(id, personDto);
    return ResponseEntity.ok(
        net.szymonsawicki.personalaitrainer.infrastructure.web.common.ApiResponse.of(
            "Person updated successfully", updated));
  }

  @DeleteMapping("/{id}")
  @Operation(summary = "Delete person by ID")
  @ApiResponses(
      value = {
        @ApiResponse(responseCode = "204", description = "Person deleted successfully"),
        @ApiResponse(responseCode = "404", description = "Person not found")
      })
  public ResponseEntity<Void> deletePerson(
      @Parameter(description = "Person ID") @PathVariable(name = "id") Long id) {
    personService.deletePerson(id);
    return ResponseEntity.noContent().build();
  }
}
