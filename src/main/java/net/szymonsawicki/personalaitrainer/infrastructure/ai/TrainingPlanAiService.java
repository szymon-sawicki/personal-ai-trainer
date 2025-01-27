package net.szymonsawicki.personalaitrainer.infrastructure.ai;

import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.V;
import dev.langchain4j.service.spring.AiService;
import net.szymonsawicki.personalaitrainer.domain.dto.PersonDto;
import net.szymonsawicki.personalaitrainer.domain.dto.TrainingPreferenceDto;

@AiService
public interface TrainingPlanAiService {

  @SystemMessage(
      """
        You are an experienced professional personal trainer with over 15 years of expertise in:
        - Calisthenics and bodyweight training
        - Pilates and mobility work
        - Weight lifting and strength training
        - Kettlebell training and functional fitness
        - Rehabilitation and injury prevention

        Your responsibilities:
        1. Create personalized training plans considering the client's:
           - Physical characteristics (age, gender, height, weight)
           - Medical conditions and limitations
           - Training preferences and schedule
           - Current fitness level
           - Goals and objectives

        2. Provide structured, clear, and detailed training plans including:
           - Weekly schedule
           - Exercise descriptions
           - Sets, reps, and progression schemes
           - Rest periods and recovery recommendations
           - Safety considerations and modifications

        Always prioritize safety and proper progression based on the client's fitness level and medical conditions.
        """)
  @UserMessage(
      """
    Create a personalized training plan in the following JSON format:
    {
      "trainingPreferenceId": {{preferenceId}},
      "startDate": "YYYY-MM-DD",
      "endDate": "YYYY-MM-DD",
      "weeklySchedules": [
        {
          "weekNumber": 1,
          "sessions": [
            {
              "dayOfWeek": "MONDAY",
              "sessionDuration": 60,
              "warmUp": {
                "exercises": [
                  {
                    "name": "string",
                    "description": "string",
                    "sets": 0,
                    "reps": 0,
                    "restPeriodSeconds": 0,
                    "notes": "string",
                    "type": "WARMUP",
                    "place": "GYM|HOME|OUTDOOR",
                    "requiredEquipment": ["DUMBBELLS", "RESISTANCE_BANDS"]
                  }
                ],
                "duration": 10
              },
              "mainExercises": [
                {
                  "name": "string",
                  "description": "string",
                  "sets": 0,
                  "reps": 0,
                  "restPeriodSeconds": 0,
                  "notes": "string",
                  "type": "STRENGTH|CARDIO|MOBILITY",
                  "place": "GYM|HOME|OUTDOOR",
                  "requiredEquipment": ["DUMBBELLS", "RESISTANCE_BANDS"]
                }
              ],
              "coolDown": {
                "exercises": [
                  {
                    "name": "string",
                    "description": "string",
                    "sets": 0,
                    "reps": 0,
                    "restPeriodSeconds": 0,
                    "notes": "string",
                    "type": "COOLDOWN",
                    "place": "GYM|HOME|OUTDOOR",
                    "requiredEquipment": []
                  }
                ],
                "duration": 10
              }
            }
          ]
        }
      ],
      "nutritionGuidelines": {
        "dailyCalories": 0,
        "proteinGrams": 0,
        "carbsGrams": 0,
        "fatsGrams": 0,
        "mealRecommendations": ["string"],
        "supplementRecommendations": ["string"]
      },
      "recoveryGuidelines": {
        "recoveryActivities": ["string"],
        "recommendedSleepHours": 0,
        "stretchingRoutines": ["string"],
        "mobilityExercises": ["string"]
      },
      "progressionStrategy": {
        "progressionTimeframeWeeks": 0,
        "progressionMethod": "string",
        "progressionMilestones": ["string"],
        "adjustmentGuidelines": ["string"]
      }
    }

    Personal Information:
    {{person}}

    Training Preferences:
    {{preferences}}

    Please ensure:
    1. All dates are in ISO format (YYYY-MM-DD)
    2. Exercise types match the enumerated values: STRENGTH, CARDIO, MOBILITY, WARMUP, COOLDOWN
    3. Training places match: GYM, HOME, OUTDOOR
    4. Days of week are in uppercase: MONDAY, TUESDAY, etc.
    5. Duration values are in minutes
    6. Rest periods are in seconds
    7. All numerical values are positive integers
    8. Equipment matches available options: DUMBBELLS, RESISTANCE_BANDS, YOGA_MAT, etc.

    The response must be valid JSON that can be directly parsed into the provided DTO structure.
    """)
  String createTrainingPlan(
      @V("person") PersonDto person,
      @V("preferences") TrainingPreferenceDto preferences,
      @V("preferenceId") Long preferenceId);
}
