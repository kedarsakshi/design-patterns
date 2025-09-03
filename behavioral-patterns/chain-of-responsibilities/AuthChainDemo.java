
abstract class AuthHandler {
protected AuthHandler nexAuthHandler;

public void setNextHandler(AuthHandler nexAuthHandler){
    this.nexAuthHandler=nexAuthHandler;
}
    public abstract void handleRequest(String username ,String password);
}


class ValidationHandler extends AuthHandler{
    @Override
    public void handleRequest(String username, String password) {
        if(username == null || password == null){
            System.out.println("Validation failed: Missing credentials!");
            return;
        }
         System.out.println("Validation passed.");
        if(nexAuthHandler != null){
            nexAuthHandler.handleRequest(username,password);
        }
    }
}

class AuthenticationHandler extends AuthHandler{

    @Override
    public void handleRequest(String username, String password) {
        if("admin".equals(username) && "1234".equals(password)){
             System.out.println("Authentication successful.");
            if (nexAuthHandler != null) {
                nexAuthHandler.handleRequest(username, password);
            }
        } else {
            System.out.println("Authentication failed: Invalid username or password!");
        }
        }
    }

    class AuthorizationHandler extends AuthHandler{

        @Override
        public void handleRequest(String username, String password) {
             if ("admin".equals(username)) {
            System.out.println("Authorization granted: Admin access.");
        } else {
            System.out.println("Authorization denied: User not allowed.");
        }
        }
    }

public class AuthChainDemo {
    public static void main(String[] args) {
        AuthHandler validation = new ValidationHandler();
        AuthHandler authentication = new AuthenticationHandler();
        AuthHandler authorization = new AuthorizationHandler();

        // Build the chain
        validation.setNextHandler(authentication);
        authentication.setNextHandler(authorization);

        // Requests
        System.out.println("\n--- Test 1: Valid Credentials ---");
        validation.handleRequest("admin", "1234");

        System.out.println("\n--- Test 2: Missing Credentials ---");
        validation.handleRequest(null, "1234");

        System.out.println("\n--- Test 3: Wrong Password ---");
        validation.handleRequest("admin", "wrong");
    }
}
