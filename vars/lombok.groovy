import es.yan.CommandWrapper
def call(){
    CommandWrapper grapper=new CommandWrapper("ln -ls", false);
    return grapper.executeCommand()
}