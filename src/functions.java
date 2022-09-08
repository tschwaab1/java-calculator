import java.util.ArrayList;


public class functions extends CalculatorPane{
	
	static int count = 0;
	
	
	public static String R8(int n) {
		
		String result = "";
		
        boolean zahl[] = new boolean[n+1]; 
        for(int i=0;i<n;i++) 
            zahl[i] = true; 
          
        for(int p = 2; p*p <=n; p++) 
        { 
            if(zahl[p] == true) 
            { 

                for(int i = p*2; i <= n; i += p) 
                    zahl[i] = false; 
            } 
        } 
          
        for(int i = 2; i <= n; i++) 
        { 
            if(zahl[i] == true) 
            	result = result +i+",";
           
        }
        
        return result;
	}

	public static int R9(int n1, int n2) {
		 if (n1 == 0) 
	            return n2; 
	          
	        return R9(n2%n1, n1); 
		
	}
	
	private static boolean R10Prime(int n) {

		if (n <= 1) {
		    return false;
		}
		
		for (int i = 2; i < n; i++) {
		    if (n % i == 0) {
		        return false;
		    }
		}
		return true; 
		
	}
	
	public static String R10(int n) {
		
		String result ="";

		int b=0;
		
		
		for (int i = 2; i <= n; i++)  
		{ 
		    if (R10Prime(i)) {
		    	
		    		b = b +1;
		    				    	
		    		result = ""+b;
		    } 
		}
		//AddToTA("Function 10 result is: "+result);
		
		return result;
	}
	
	public static int R11(int n1) {
		    int result = n1;
		    for (int i = 2; i * i <= n1; i++) {
		        if(n1 % i == 0) {
		            while(n1 % i == 0)
		                n1 /= i;
		            result -= result / i;
		        }
		    }
		    if(n1 > 1) {
		        result -= result / n1;
		    }
		    return result;
		}
	
	public static String R12(int n) {
		String result ="";

        while (n%2==0) 
        { 
            result = result + 2 + " ";
            n /= 2; 
        } 
  
        for (int i = 3; i <= Math.sqrt(n); i+= 2) 
        { 

            while (n%i == 0) 
            { 
                result = result + i + " "; 
                n /= i; 
            } 
        } 
  
        if (n > 2) {
        	result = result + n + " ";
        }
        return result;
	}

	public static int R13(int x, int n) {
		

		int sum =0;
		
		ArrayList<Integer> div = new ArrayList<Integer>();

        for (int i=1;i<=n;i++) {
        	
            if (n%i==0) {
                div.add(i);
            }
        }

        for (int i1=0;i1<=(div.size()-1);i1++) {
        	
       // 	System.out.println("Is anything inside here executed? "+i1);
        	        	
        	int a = div.get(i1);        
        	sum = (int) (sum + Math.pow(a,x));
        //Only Debug stuff	AddToTA("a ist: "+a+" i: "+i1+" sum: "+sum);
        	
        }
		return sum;
		  
		
	}
	
	public static int lincongen (int a, int b, int m, int n) {
		
				if (n == 0) {
		
						return 22;
				}
				
		return (((a *lincongen(a, b, m, n-1)) + b) % m);
		}
	
	
	
	public static ArrayList<Integer> R14(int a, int b, int m, int n) {
	        
		ArrayList<Integer> zahlen = new ArrayList<Integer>();

					if (n == 0) {
							zahlen.add(11);
					}
	        
					for (int i = 1; i <= n; i++) {
	            
						int x = lincongen(a, b, m, i);
						zahlen.add(x);
					}
	        return (zahlen);
	    }
	
	public static void R15(int n) {
       
		int num = 0;
        int[] e = new int[n];
        e[num] = n;
        
        while (true) 
        { 
        	 int part = 0; 
        	count = count +1;
        	
        	while (num >= 0 && e[num] == 1) 
            { 
                part += e[num]; 
                num--; 
            } 
   
            if (num < 0) {
            	
            	return; 
            }  

            e[num]--; 
            part++; 

            while (part > e[num]) 
            { 
                e[num+1] = e[num]; 
                part = part - e[num]; 
                num++; 
            } 

            e[num+1] = part; 
            num++; 
        } 
	}

	public static int getPartys (int a) {
		R15(a);
		
		return count;
		}
	
	public static void setCountZero() {
		count = 0;
	}
	
	
}
