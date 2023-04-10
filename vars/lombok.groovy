import es.yan.CommandWrapper
def call(){
    CommandWrapper grapper=new CommandWrapper("ln -ls", false);
    grapper.executeCommand()
    return  grapper
}