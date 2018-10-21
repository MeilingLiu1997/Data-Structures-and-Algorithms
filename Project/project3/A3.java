
import java.util.List;
import java.util.Scanner;


public class A3 {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.err.println("Usage: A3 <filename>");
            System.exit(1);
        }
        String filename = args[0];
        Graph<String, Integer> graph = RecordLoader.fileReader(filename);
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Actor 1 name: ");
            String actor1 = scanner.nextLine();

            Name fixedactor1 = new Name(actor1.split(" "));
            if (!graph.contain(actor1) && 
            	!graph.contain(fixedactor1.toString())) {
	            	System.err.println("No such actor.");
                	continue;
            }
            System.out.print("Actor 2 name: ");
            String actor2 = scanner.nextLine();

            Name fixedactor2 = new Name(actor2.split(" "));
            if (!graph.contain(actor2) &&
            	!graph.contain(fixedactor2.toString())) {
                System.err.println("No such actor.");
                continue;
            }

            List<String> actors = graph.findShortest(actor1, actor2);
            if (actors == null) {
                System.err.println("No such path");
                continue;
            }
            String path = "";
            for (int i = 0; i < actors.size(); i++) {
                if (i == actors.size() - 1) {
                    path += actors.get(i);
                } else {
                    path += actors.get(i) + " --> ";
                }
            }
            System.out.println("Path between " + actor1 + " and " + actor2 + ": " + actor1 + " --> " + path);
        }
    }
}
