
public class QuestionDefinition {
  private String definition;

  /**
   * @return the definition
   */
  public String getDefinition() {
    return definition;
  }

  private String reponse;

  /**
   * @return the reponse
   */
  public String getReponse() {
    return reponse;
  }

  private int long_rep;

  /**
   * @return the long_rep
   */
  public int getLong_rep() {
    return long_rep;
  }

  public QuestionDefinition(String definition, String reponse) {
    this.definition = definition;
    this.reponse = reponse;
    this.long_rep = reponse.length();
  }

}
