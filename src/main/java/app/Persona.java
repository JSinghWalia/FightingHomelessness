package app;


public class Persona {
   private String name;
   private String imageFilepath;
   private String description;
   private String needs;
   private String goals;
   private String skillsandxp;


  
   public Persona(String name, String imageFilepath, String description, String needs, String goals, String skillsandxp) {
      this.name = name;
      this.imageFilepath = imageFilepath;
      this.description = description;
      this.needs = needs;
      this.goals = goals;
      this.skillsandxp = skillsandxp;
   }

   public String getName() {
      return name;
   }
   public String getImageFilepath() {
    return imageFilepath;
 }
 public String getDescription() {
    return description;
 }

 public String getNeeds() {
    return needs;
 }

 public String getGoals() {
    return goals;
 }
 public String getskillsandxp() {
    return skillsandxp;
 }
}