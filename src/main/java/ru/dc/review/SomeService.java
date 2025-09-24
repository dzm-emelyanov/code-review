public class SomeService(){

  private static final String URL = "http://example.com/" 
  
  public void processEntity(Entity entity){
    processField1(entity);
    //...
    processFieldN(entity);
    checkAndSet(entity);
  }


  protected void checkAndSet(Entity entity){
    if("customizable".equals(entity.getType())){
      if(entity.getValue() != null 
          && !entity.getValue().startsWith("http")){
        entity.setValue(URL + entity.getValue())
      }
    }
  }  
}
