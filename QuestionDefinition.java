public class QuestionDefinition extends CaseQuestion {
  private String definition;
  private String reponse;
  private int long_rep;

  public QuestionDefinition(String definition, String reponse) {
    this.definition = definition;
    this.reponse = reponse;
    this.long_rep = reponse.length();
  }

}
