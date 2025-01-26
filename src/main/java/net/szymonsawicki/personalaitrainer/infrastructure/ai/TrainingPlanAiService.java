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
    Create a personalized training plan for:

    Personal Information:
  {{person}}

    Training Preferences:
    {{preferences}}


    Please provide a detailed training plan including:
    1. Weekly schedule with specific days
    2. Detailed workout for each session including:
       - Warm-up routine
       - Main exercises with sets, reps, and rest periods
       - Cool-down and mobility work
    3. Progressive overload strategy
    4. Nutrition recommendations
    5. Recovery guidelines

    Format the response in a clear, structured manner using markdown.
  """)
  String createTrainingPlan(
      @V("person") PersonDto person, @V("preferences") TrainingPreferenceDto preferences);
}
