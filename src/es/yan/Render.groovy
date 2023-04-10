public class Render {
  private Map config
  
  public Render (Map config){
    this.config = config
  }

  def Rendering() {
    def engine = new groovy.text.GStringTemplateEngine()
    def template = engine.createTemplate(this.config.input).make(this.config.binding)
    return template.toString()
  }
}
