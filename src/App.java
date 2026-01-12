import java.util.*;
public class App
{

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        try{
            System.out.println("🚗Welcome To Smart Car Garage🚗");
            //customer details

            System.out.println("Enter customer name:");
            String name=sc.nextLine();

            System.out.println("Enter car number:");
            String carNo=sc.nextLine();

            System.out.println(" Car Type(Hatchback/Sedan/SUV): ");
            String carType=sc.nextLine();

            Customer customer=new Customer(name,carNo,carType);

            //Availabel Service
            Service[] services={
                    new Service(1,"Car wash",300),
                    new Service(2,"Oil Change",400),
                    new Service(3,"Break Check",150),
                    new Service(4,"coolant Change",500),
                    new Service(5,"Full Service",10000),

            };

            boolean[] selected=new boolean[services.length];
            while (true){
                System.out.println("\n🚗 Available Services");
                int index=0;
                for(Service s:services) {
                    if (!selected[index]) {
                        System.out.println(s.getId() + " " + s.getName() + " -₹" + s.getPrice());

                    }
                    index++;
                }




                System.out.println("0. Generate Bill");
                System.out.println("select Services Id:");
                int choice=sc.nextInt();


                if(choice<0 || choice>services.length){
                    throw new Exception("Invalid service Selection");
                }



                //int total=BillCalculator.calculateTotal(services,selected);

                if(choice==0){
                    int total=BillCalculator.calculateTotal(services,selected);
                    //Final Billing

                    System.out.println("\n-----------FinalBill----------");
                    System.out.println("customer name:"+customer.getName());
                    System.out.println("CarNo: "+customer.carNumber);
                    System.out.println("CarType "+customer.carType);

                    System.out.println("\nservice Availed:");
                    for(int i=0;i<services.length;i++){
                        if(selected[i])
                        {
                            System.out.println("-"+services[i].getName()+" : ₹"+services[i].getPrice());
                        }
                    }
                    System.out.println("-----------------");
                    System.out.println("Total amount: "+total);
                    System.out.println("Thank you! Visit Again");

                    break;
                }
                System.out.println("Service Added:"+services[choice-1].getName());
                selected[choice-1]=true;



            }

        }
        catch (Exception e) {
            System.out.println("Error: "+e.getMessage());
        }
    }
}
