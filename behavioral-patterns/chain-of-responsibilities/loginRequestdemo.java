
abstract class requestHandler{
    protected requestHandler nexRequestHandler;

    public void setNextHandler(requestHandler nexRequestHandler){
        this.nexRequestHandler=nexRequestHandler;
    }

    public abstract void handleRequest(String request);
}

class level1 extends requestHandler{

    @Override
    public void handleRequest(String request) {
        if(request.equals("forgot password")){
            System.out.println("Level 1 : request is handled ");
        }else{
             System.out.println("Level 1 : request is not handled ");
             if(nexRequestHandler != null){
                nexRequestHandler.handleRequest(request);
             }
        }
    }
}

class level2 extends requestHandler{

    @Override
    public void handleRequest(String request) {
        if(request.equals("app crash")){
             System.out.println("Level 2 : request is handled - "+request);
        }
        else{
             System.out.println("Level 2 : request is not handled ");
             if(nexRequestHandler != null){
                nexRequestHandler.handleRequest(request);
             }
        }
    }
}

class level3 extends requestHandler{
    @Override
    public void handleRequest(String request) {
        System.out.println("Level 3 Support (Manager): Resolved critical issue - " + request);
    }
}
public class loginRequestdemo {

    public static void main(String[] args) {
        requestHandler r1Handler=new level1();
        requestHandler r2Handler=new level2();
        requestHandler r3Handler=new level3();

        r1Handler.setNextHandler(r2Handler);
        r2Handler.setNextHandler(r3Handler);

        r1Handler.handleRequest("app crash");
        r2Handler.handleRequest("forgot password");
        r3Handler.handleRequest("wrong pass");
    }
}