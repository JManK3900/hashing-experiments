import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;


//RUN java HashTableTest 1 0.90 #<-(0 through 2)

public class HashtableTest
{
    public static void main(String[] args) throws Exception
    {
        int debugLevel=0;

        if(args.length<1) throw new IllegalArgumentException("Java HashTableTest <dateType> <loadFactor> [<debugLevel>]");

        if(args.length==3) debugLevel=Integer.parseInt(args[2]);
        //if(debugLevel<0 || debugLevel>2) throw new IllegalArgumentExpection("Java HashTableTest <dateType> <loadFactor> [<debugLevel>]");
        if(debugLevel<0 || debugLevel>2) throw new IllegalArgumentException("Debug level must be between 0 and 2");

        double loadFactor = Double.parseDouble(args[1]);

        switch(Integer.parseInt(args[0]))
        {
            case 1: //ints
                LinearProbing<Integer> lphi = new LinearProbing<Integer>(loadFactor, 95791);
                DoubleHashing<Integer> dhi = new DoubleHashing<Integer>(loadFactor, 95791);
                lphi.setDebugLevel(debugLevel); //@@@
                dhi.setDebugLevel(debugLevel); //@@@
                Random r = new Random();
                int c = 0;
                while(lphi.size != lphi.maxSize)
                {
                    int foo;
                    lphi.put(foo = r.nextInt());
                    dhi.put(foo);
                    if(debugLevel == 2){
                        if(lphi.isDupe == 0){
                            System.out.println("Table["+ c +"]: is a duplicate");
                        }
                        else{
                            System.out.println("Table["+ c +"]: is a successful probe");
                        }
                        if(dhi.isDupe == 0){
                            System.out.println("Table["+ c +"]: is a duplicate");
                        }
                        else{
                            System.out.println("Table["+ c +"]: is a successful probe");
                        }
                    }
                    c++;
                }

                //"table[" + index + "]: " + toString()
                if(debugLevel == 0){
                    // for(int i = 0; i<lphi.maxSize;i++){
                        System.out.println(" ");
                        System.out.println("HashtableTest: Found a twin prime table capacity: 95791");
                        System.out.println("HashtableTest: Input: Ints  Loadfactor: " + loadFactor);
                        System.out.println("\t Using Linear Probing");
                        System.out.println("HashtableTest: size of hash table is " + lphi.size);
                        System.out.println("\t Inserted " + lphi.getProbe() + " elements, of which " +  lphi.getDupeCount() + " were duplicates");
                        System.out.println("\t\t Avg. no. of probes = " + lphi.getProbeAvg());
                        
                        System.out.println(" ");

                        System.out.println("\t Using Double Hashing");
                        System.out.println("HashtableTest: size of hash table is " + dhi.size);
                        System.out.println("\t Inserted " + dhi.getProbe() + " elements, of which " + dhi.getDupeCount() + " were duplicates");
                        System.out.println("\t\t Avg. no. of probes = " + dhi.getProbeAvg());
                    // }
                }
                else if(debugLevel == 1){
                    PrintWriter output = new PrintWriter("Int-list-" + loadFactor + "-linear-dump.txt");
                    for(int i = 0; i<lphi.maxSize;i++){
                        if(lphi.array[i] != null){
                            try {

                                output.println("table["+i+"]: " + lphi.array[i].toString());
                                

                            } catch (Exception e) {
                                e.getStackTrace();
                            }
                        }
                    }
                    output.close();

                    PrintWriter output2 = new PrintWriter("Int-list-" + loadFactor + "-double-dump.txt");
                    for(int i = 0; i<dhi.maxSize;i++){
                        if(dhi.array[i] != null){
                            try {

                                output2.println("table["+i+"]: " + dhi.array[i].toString());

                            } catch (Exception e) {
                                e.getStackTrace();
                            }
                        }
                    }
                    output2.close();
                }
                else{
                    
                }

                


            break;
            case 2: //dates(longs)
                LinearProbing<Date> lphl = new LinearProbing<Date>(loadFactor, 95791);
                DoubleHashing<Date> dhl = new DoubleHashing<Date>(loadFactor, 95791);
                lphl.setDebugLevel(debugLevel);
                dhl.setDebugLevel(debugLevel);

                Long current = new Date().getTime();
                int i = 0;
                while(lphl.size != lphl.maxSize)
                {
                    Date date = new Date(current);
                    lphl.put(date);
                    dhl.put(date);
                    current += 1000;
                    if(debugLevel == 2){
                        if(lphl.isDupe == 0){
                            System.out.println("Table["+ i +"]: is a duplicate");
                        }
                        else{
                            System.out.println("Table["+ i +"]: is a successful probe");
                        }
                        if(dhl.isDupe == 0){
                            System.out.println("Table["+ i +"]: is a duplicate");
                        }
                        else{
                            System.out.println("Table["+ i +"]: is a successful probe");
                        }
                        i++;
                    }
                }
                

                if(debugLevel == 0){
                    System.out.println(" ");
                        System.out.println("HashtableTest: Found a twin prime table capacity: 95791");
                        System.out.println("HashtableTest: Input: Dates  Loadfactor: " + loadFactor);
                        System.out.println("\t Using Linear Probing");
                        System.out.println("HashtableTest: size of hash table is " + lphl.size);
                        System.out.println("\t Inserted " + lphl.getProbe() + " elements, of which " +  lphl.getDupeCount() + " were duplicates");
                        System.out.println("\t\t Avg. no. of probes = " + lphl.getProbeAvg());
                        
                        System.out.println(" ");

                        System.out.println("\t Using Double Hashing");
                        System.out.println("HashtableTest: size of hash table is " + dhl.size);
                        System.out.println("\t Inserted " + dhl.getProbe() + " elements, of which " + dhl.getDupeCount() + " were duplicates");
                        System.out.println("\t\t Avg. no. of probes = " + dhl.getProbeAvg());
                }
                else if(debugLevel == 1){
                    PrintWriter output = new PrintWriter("Long-list-" + loadFactor + "-linear-dump.txt");
                    for(int x = 0; x<lphl.maxSize;x++){
                        if(lphl.array[x] != null){
                            try {

                                output.println("table["+x+"]: " + lphl.array[x].toString());

                            } catch (Exception e) {
                                e.getStackTrace();
                            }
                        }
                    }
                    output.close();

                    PrintWriter output2 = new PrintWriter("Long-list-" + loadFactor + "-double-dump.txt");
                    for(int z = 0; z<dhl.maxSize;z++){
                        if(dhl.array[z] != null){
                            try {

                                output2.println("table["+z+"]: " + dhl.array[z].toString());

                            } catch (Exception e) {
                                e.getStackTrace();
                            }
                        }
                    }
                    output2.close();
                }
                else{
                    
                }

                //insert current time += 1000ms until load factor is hit


            break;
            case 3: // strings
                LinearProbing<String> lphs = new LinearProbing<String>(loadFactor, 95791);
                DoubleHashing<String> dhs = new DoubleHashing<String>(loadFactor, 95791);
                lphs.setDebugLevel(debugLevel);
                dhs.setDebugLevel(debugLevel);

                //insert every word from word-list.txt until load factor is hit
                try {
                    int j =0;
                    File myObj = new File("word-list.txt");
                    Scanner myReader = new Scanner(myObj);
                    while (myReader.hasNextLine()) {
                      String data = myReader.nextLine();
                      lphs.put(data);
                      dhs.put(data);
                      if(debugLevel == 2){
                            if(lphs.isDupe == 0){
                                System.out.println("Table["+ j +"]: is a duplicate");
                            }
                            else{
                                System.out.println("Table["+ j +"]: is a successful probe");
                            }
                            if(dhs.isDupe == 0){
                                System.out.println("Table["+ j +"]: is a duplicate");
                            }
                            else{
                                System.out.println("Table["+ j +"]: is a successful probe");
                            }
                        }
                        j++;
                    }
                    myReader.close();
                  } catch (FileNotFoundException e) {
                    System.out.println("An error occurred.");
                    e.printStackTrace();
                  }

                  if(debugLevel == 0){
                    System.out.println(" ");
                        System.out.println("HashtableTest: Found a twin prime table capacity: 95791");
                        System.out.println("HashtableTest: Input: Strings  Loadfactor: " + loadFactor);
                        System.out.println("\t Using Linear Probing");
                        System.out.println("HashtableTest: size of hash table is " + lphs.size);
                        System.out.println("\t Inserted " + lphs.getProbe() + " elements, of which " +  lphs.getDupeCount() + " were duplicates");
                        System.out.println("\t\t Avg. no. of probes = " + lphs.getProbeAvg());
                        
                        System.out.println(" ");

                        System.out.println("\t Using Double Hashing");
                        System.out.println("HashtableTest: size of hash table is " + dhs.size);
                        System.out.println("\t Inserted " + dhs.getProbe() + " elements, of which " + dhs.getDupeCount() + " were duplicates");
                        System.out.println("\t\t Avg. no. of probes = " + dhs.getProbeAvg());
                }
                else if(debugLevel == 1){
                    PrintWriter output = new PrintWriter("String-list-" + loadFactor + "-linear-dump.txt");
                    for(int k = 0; k<lphs.maxSize;k++){
                        if(lphs.array[k] != null){
                            try {

                                output.println("table["+k+"]: " + lphs.array[k].toString());

                            } catch (Exception e) {
                                e.getStackTrace();
                            }
                        }
                    }
                    output.close();

                    PrintWriter output2 = new PrintWriter("String-list-" + loadFactor + "-double-dump.txt");
                    for(int j = 0; j<dhs.maxSize;j++){
                        if(dhs.array[j] != null){
                            try {

                                output2.println("table["+j+"]: " + dhs.array[j].toString());

                            } catch (Exception e) {
                                e.getStackTrace();
                            }
                        }
                    }
                    output2.close();
                }
                else{
                    
                }


            break;
        }
    }
}