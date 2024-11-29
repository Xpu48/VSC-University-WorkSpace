package Lab3Ex;

public class Lab3Ex1 {
    //(a) Answer the following questions:
    //(  i) Are we allowed to instantiate a System Object?: No as this is a final class.
    //( ii) What memeber variable does System have?: in, out and error.
    //(iii) What is the type of 'out'?: Print Stream as it is a static member of the System class.

    public static void main(String[] arg){
        //String var1 = "Hello";
        //System.out.format(var1);

        long startTime = System.currentTimeMillis();

        double x= 0.0;
        for (int i = 0; i < 1000000; i++){
            x = Math.sin(i);
        }
        System.out.println(x);
        long endTime = System.currentTimeMillis();
        System.out.println("Time taken: " + (endTime - startTime) + " milliseconds");
        
        System.out.println("User: " + System.getProperty("user.name"));
        System.out.println("Home: " + System.getProperty("user.home"));
        System.out.println("OS: " + System.getProperty("os.name"));
        System.out.println("Arch: " + System.getProperty("os.arch"));
        System.out.println("Endian: " + System.getProperty("sun.cpu.endian"));
        System.out.println("runtime: " + System.getProperty("java.runtime.name"));
        System.out.println("Vm: " + System.getProperty("java.vm.name"));

        


    
    }


}
