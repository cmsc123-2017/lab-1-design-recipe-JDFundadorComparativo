//get fairChange upon recieving the ff data: paidMoney, howMany, howLong, & withDiscount
//Double, Int, Double, Boolean -> Double
/*
 * public class FareChange{
 *      public FareChange(double paidMoney, int howMany, double distance, boolean withDiscount){
 *        
 *   }
 * }
 */

public class Item{
  // variables for fareChange
  int discountedFare = 6;
  int normalFare = 7;
  double limit = 5.0;
  double add = .50;
  double money;
  int howMany;
  double distance;
  int withDiscount;
  
  //variables for salePrice1000
  int saleLimit = 1000;
  double discount;
  double cost;
  
//constructor -> recieves nothing
  public Item(){}
  //computeAdditional function computes the extra payment for distances exceeding the limit.
  // ->double (excess payment)
  /* public double computeAdditional(){
   *    return 0;
   * }
   * public double computeAdditional(){
   *    int sum...
   *    distance...
   * }*/
  public double computeAdditional(){
    double sum = 0;
    double tempdist = this.distance;
    while(tempdist > limit){
      sum += this.add;
      tempdist -= 1;
    }
    return sum;
  }
  /*noDiscount function computes fare using the value in normalFare.
   * -> double (fare for no discount)
   * public double noDiscount(){
   *   return 0;
   * }
   * public double noDiscount(){
   *   normalFare...
   * }
   */
  public double noDiscount(){
    return (normalFare + computeAdditional());
  }
  //The function below is just the same with noDiscount just change normFare to discountedFare.
  public double withDiscount(){
    return (discountedFare + computeAdditional());
  }
  /*computeFare function is the main computer of the necessary payment. It isolates the discounted from the NDs 
   * -> double (total payment)
   * public double computeFare(){
   *  return 0;
   * }
   * public double computeFare(){
   *  howMany...
   *  withDiscount...
   *  noDiscount...
   * }
   */
  public double computeFare(){
    return ((this.howMany - this.withDiscount) * noDiscount()) + (withDiscount* withDiscount());
  }
  /*fareChange function reduces the value in computeFare() from the "money". This function also recieves the data needed.
   *double, int , double, int -> double
   * public double fareChange(double money, int howMany, double distance, int withDiscount){
   *   return 0;   
   * }
   * public double fareChange(double money, int howMany, double distance, int withDiscount){
   *   money..
   *   howMany...
   *   distance..
   *   withDiscount...
   * }
   */
  public double fareChange(double money, int howMany, double distance, int withDiscount){
    this.money = money;
    this.howMany = howMany;
    this.distance = distance;
    this.withDiscount = withDiscount;
    if(money > computeFare())
      return money - computeFare();
    else{
      System.out.println("Invalid inputs. Money is not enough");
      return 0; 
    }
  }
  /* saleValid() decides wether the item has a discount or not by determining if cost exceeds saleLimit
   *  -> boolean (decision)
   *  public boolean saleValid(){
   *   return false;
   * }
   * public boolean saleValid(){
   *   this.cost...
   *   this.saleLimit...
   * }
   * */
  public boolean saleValid(){
    return (this.cost > this.saleLimit);
  }
  /* computeSalePrice() multiplies cost with discount. 
   *  -> double (discounted price)
   * public double computeSalePrice(){
   *   return 0;
   * }
   * public double computeSalePrice(){
   *   discount...
   *   cost...
   * }
   * */
  public double computeSalePrice(){ 
      return this.discount*this.cost; 
  }
  /* salePrice() assigns the collected data then returns whatever computeSalePrice() returns if saleValid() is true.
   * double, double -> double
   * public double salePrice1000(double cost, double discount){
   *  return 0;
   * }
   * public doube salePrice1000(double cost, double discount){
   *  cost...
   *  discount...
   * }
   * */
  public double salePrice1000(double cost, double discount){
    this.cost = cost;
    this.discount = discount;
    if(saleValid())
      return this.cost - computeSalePrice();
    else{
      System.out.println("Item cost did not exceed 1000");
      return this.cost;}
  }
}