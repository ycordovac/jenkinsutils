package es.yan


class CommandWrapper{
    String metadataFecha
    String metadataCommand
    boolean executed
    StringBuilder result
    StringBuilder error
    String agent
    String step
    Map<String, StringBuilder> resultMap

    public CommandWrapper(String commandtoExecute){
        this.metadataCommand=commandtoExecute
    }

    public CommandWrapper(){
        
    }

    String getMetadataCommand(){
        return metadataCommand
    }

    boolean executeCommandWaitAndFillValues(String commandtoExecute){
        this.agent=env.NODE_NAME
        this.metadataFecha=new Date()
        this.metadataCommand=commandtoExecute
        this.step=env.STAGE_NAME
        this.execute=false
        Map<String, StringBuilder> execute=executeCommand(commandtoExecute, true)
        this.result=execute.get("result")
        return result==null
    }

    boolean executeCommandAndFillValues(String commandtoExecute){
        this.agent=env.NODE_NAME
        this.metadataFecha=new Date()
        this.metadataCommand=commandtoExecute
        this.step=env.STAGE_NAME
        this.execute=false
        Map<String, StringBuilder> execute=executeCommand(commandtoExecute, false)
        this.result=execute.get("result")
        return this.result==null
    }

    Map<String, StringBuilder> executeCommand(String commandtoExecute, boolean wait){
        resultMap=new HashMap()
        def result = new StringBuilder()
        def error     = new StringBuilder()

        def comando = commandtoExecute.execute()
        comando.consumeProcessOutput(result, error)
        if(wait){
            comando.waitForOrKill(1000)
        }

        if (!error.toString().equals(""))
            resultMap.put("error", error)
        if(!result.toString().equals(""))
            resultMap.put("result", result)
    }

    Map<String, StringBuilder> executeCommand(){
        return executeCommand(this.metadataCommand, false)
    }
}