public class Main {
    public static void main(String[] args) {
        int input[] = {1, 2, 3, 5, 5};
        int input2 [] = {0, 0, 0, 6, 6};


        System.out.println(occurrences(input, 5));
        System.out.println(max_occurrences(input2)[1]);


        int rankings1 [] = {5, 5, 5, 5, 11};
        int rankings2 [] = {5, 5, 5, 5, 8};
        int suits1 [] = {1, 2, 3, 3, 4};
        int suits2 [] = {4, 3, 3, 3, 3};


        System.out.println(hand_comparison(rankings1, rankings2, suits1, suits2));

    }

    //counts occurences of y in arrray x

    private static int occurrences(int[] x, int y){
        int r = 0;
        for (int number = 0; number < 5; number++){
            if (x[number] == y) {
                r = r + 1;
            }
        }
        return r;
    }

    //outputs the number that occurs the most as an array: {number, occurrences}, unless the number is 0 in which case it is ignored.

    private static int[] max_occurrences(int[] x){
        int[] r = {0, 0};
        for (int number = 0; number < 5; number++){
            if (occurrences(x, (x[number])) > r[1] && x[number] != 0){
                r[0] = x[number];
                r[1] = occurrences(x, x[number]);
            }
        }
        return r;
    }
    //removes all occurrences of y and replaces them with 0
    //I'm doing this because I think removing items from an array and not replacing them with anything is impossible in Java, right?

    private static int[] remove(int[] x, int y){
        int[] dummyx = new int[x.length]
        for (int number = 0; number < 5; number++){
            dummyx[number] = x[number]
            if (x[number] == y){
                dummyx[number] = 0;
            }
        }
        return dummyx;
    }
    private static int maximum(int[] x){
        int r = 0;
        for(int number = 0; number < 5; number++){
            if (x[number] > r){
                r = x[number];
            }
        }
        return r;
    }

    private static int minimum(int[] x){
        int r = 100;
        for (int number = 0; number < 5; number++){
            if (x[number] < r && x[number] != 0){
                r = x[number];
            }
        }
        return r;
    }
    
   private static int size(int[] x){
        int r = 0;
        r = r + (maximum(x)*50625);
        x = remove(x, maximum(x));
        r = r + (maximum(x)*3375);
        x = remove(x, maximum(x));
        r = r + (maximum(x)*225);
        x = remove(x, maximum(x));
        r = r + (maximum(x)*15);
        x = remove(x, maximum(x));
        r = r + (maximum(x));

        return r;


    //finally the main function
    //if player 1 has the better cards, returns 1. if player 2 has the better cards, it returns 2, and if they are equal, returns 0.
    //suits are 1: spades 2: hearts 3: clubs 4: diamonds
    //rankings are 2 through 14 
    
    private static int hand_comparison(int[] rankings1, int[] rankings2, int[] suits1, int[] suits2){
        
        // insert straight-flush checker here, because straight-flush is better than 4-of-a-kind, just a bit of a pain to program 
       


        //checking four-of-a-kind

        if (max_occurrences(rankings1)[1] == 4 && max_occurrences(rankings2)[1] != 4){
            return 1;
        }
        if (max_occurrences(rankings2)[1] == 4 && max_occurrences(rankings1)[1] != 4){
            return 2;
        }
        if (max_occurrences(rankings2 )[1] == 4 && max_occurrences(rankings1)[1] == 4){

            if (max_occurrences(rankings1)[0] > max_occurrences(rankings2)[0]){
                return 1;
            }

            if (max_occurrences(rankings2)[0] > max_occurrences(rankings1)[0]){
                return 2;
            }

            if (max_occurrences(rankings1)[0] == max_occurrences(rankings2)[0]){

                int[] dummy_rankings1 = remove(rankings1, max_occurrences(rankings1)[0]);
                int[] dummy_rankings2 = remove(rankings2, max_occurrences(rankings2)[0]);

                if (maximum(dummy_rankings1) > maximum(dummy_rankings2)){
                    return 1;
                }
                if (maximum(dummy_rankings2) > maximum(dummy_rankings1)){
                    return 2;
                }
                else {
                    return 0;
                }
            }
        }
        
        
        
        // check for the rest of possibilities, using a similar process to above
        //in order from best to worst:
        
        //full house
        boolean h1HasFH = false;
        boolean h2HasFH = false;
        if(max_occurences(rankings1)[1] == 3){
            int[] dummy_rankings1 = remove(rankings1,maxoccurences(rankings1)[0]);
            if(max_occurences(dummy_rankings1)[1] == 2){
                h1HasFH = true;
                
            }
              
        }
        
         if(max_occurences(rankings2)[1] == 3){
            int[] dummy_rankings2 = remove(rankings2,maxoccurences(rankings2)[0]);
            if(max_occurences(dummy_rankings2)[1] == 2){
                h2HasFH = true;
                
            }
              
        }
        
        if (h1HasFH && !h2HasFH){
            return 1;
        }
        
        if(h2HasFH && !h1HasFH){
            return 2;
        }
        
        if(h1HasFH && h2HasFH){
            
        }
        
        
                
        //flush
        if (max_occurrences(suits1)[1] == 5 && max_occurrences(suits2)[1] != 5){
            return 1;
        }

        if (max_occurrences(suits1)[1] != 5 && max_occurrences(suits2)[1] == 5){
            return 2;
        }

        if (max_occurrences(suits1)[1] == 5 && max_occurrences(suits2)[1] == 5){
            if (size(rankings1) > size(rankings2)){
                return 1;
            }
            if (size(rankings1) < size(rankings2)){
                return 2;
            }
            else {
                return 0;
            }
        }
                
 
        //straight
        
        if ((max_occurrences(rankings1)[1] == 1 && maximum(rankings1) - minimum(rankings1) == 4) && !(max_occurrences(rankings2)[1] == 1 && maximum(rankings2) - minimum(rankings2) == 4)){
            return 1;
        }
        if ((max_occurrences(rankings2)[1] == 1 && maximum(rankings2) - minimum(rankings2) == 4) && !(max_occurrences(rankings1)[1] == 1 && maximum(rankings1) - minimum(rankings1) == 4)){
            return 2;
        }
        if ((max_occurrences(rankings1)[1] == 1 && maximum(rankings1) - minimum(rankings1) == 4) && (max_occurrences(rankings2)[1] == 1 && maximum(rankings2) - minimum(rankings2) == 4)){

            if (size(rankings1) > size(rankings2)){
                return 1;
            }
            if (size(rankings1) < size(rankings2)){
                return 2;
            }
            else {
                return 0;
            }
        }
        
        //three-of-a-kind
        //two pairs
        //one pair
        //high card (meaning nothing)
        
        // this place is still completely incomplete
        
        return 0; //if we weren't able to determine a winner the hands are equal
    }
}

