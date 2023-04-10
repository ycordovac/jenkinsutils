import es.yan.CommandWrapper
def call(){
    CommandWrapper grapper=new CommandWrapper("ln -ls");
    grapper.executeCommand()
    return  grapper
}