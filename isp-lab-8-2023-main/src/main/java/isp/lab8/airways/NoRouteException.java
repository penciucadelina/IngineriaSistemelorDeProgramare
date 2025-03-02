
package isp.lab8.airways;

public class NoRouteException extends Exception{
    public NoRouteException() {
        System.out.println("No available routes");
    }
}
