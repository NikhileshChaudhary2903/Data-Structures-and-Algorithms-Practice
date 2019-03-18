static void  printSumDice(int digits,int sum,List<Integer> list) {
		// digits is the no of digits left to process here
		if(digits == 0) {
			// base case
			if(sum==0)
				System.out.println(list.toString());
		}else {

			for(int i=1;i<=6;i++)
			{
				list.add(i); // choose  
				printSumDice(digits-1,sum-i,list); // explore since we already choose one digit
				list.remove(list.size()-1);	// retract or unchoose
			}
		}

	}
