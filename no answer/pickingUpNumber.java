public static int pickingNumbers(List<Integer> a) {
    // Write your code here
        int result =0, tempVal=0;
        List<Integer> subArray = new ArrayList<>();
        List<Integer> resultArray = new ArrayList<>();
        for(int i =0; i< a.size(); i++){
            
            //tempVal = i;
            subArray.add(a.get(i));
            for (int j =i+1 ;j<a.size();j++){
                
                //tempVal = subArray.get(subArray.size() - 1);
                System.out.println("before check 1"+subArray);
                //System.out.println("before check 1"+subArray);
                
                    tempVal = subArray.get(subArray.size() - 1);
                
                // System.out.println(" before "+subArray);
                System.out.println(" before val " + j+ " "+a.get(j));
                System.out.println(" before val "+ i+ " "+a.get(i));
                // System.out.println(" before val temp "+a.get(tempVal));
                // boolean val = (Math.abs(a.get(j) - a.get(i))<=1) && (Math.abs(a.get(j) - a.get(tempVal)) <=1);
                //System.out.println(" condition "+ val);
                
                //tempVal = subArray.get(subArray.size() - 1);
                System.out.println("tempVal: " +tempVal);
                if((Math.abs(a.get(j) - a.get(i))<=1) &&((Math.abs(a.get(j) - tempVal)<=1)) ){
                    subArray.add(a.get(j));
                    
                }
                if((Math.abs(a.get(j) - tempVal) >1)){
                    resultArray.add(subArray.size());
                    System.out.println(" check 1"+subArray);
                    subArray.clear();
                    subArray.add(a.get(i));
                    if((Math.abs(a.get(j) - a.get(i))<=1)){
                        subArray.add(a.get(j));
                    }
                }
                
                
                
                
                
                // if(Math.abs(a.get(j) - a.get(tempVal)) >1){
                //     subArray.clear();
                // }
                //tempVal++;
            }
            //System.out.println("check2" + subArray);
            // resultArray.add(subArray.size());
            subArray.clear();
            
            
        }
        System.out.println(resultArray);
        for(Integer integer: resultArray){
            if(integer >=result){
                result = integer;
            }
        }
        return result;
    }