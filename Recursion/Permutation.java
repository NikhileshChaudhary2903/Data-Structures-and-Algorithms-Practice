static void permute(String str,StringBuilder chosen,boolean used[],CountCalls calls) {

		if(chosen.length() == str.length()) {
			System.out.println(chosen.toString());
			calls.val++;
		} else {

			for(int i=0;i<str.length();i++)
			{
				if(used[i] == false) {	
					char first = str.charAt(i);  // choose
					used[i] = true;
					chosen.append(first); // choose
					permute(str,chosen,used,calls); // explore 
					used[i] = false; // backtrack
					chosen.deleteCharAt(chosen.length()-1); //backtrack
				}
			}
		}

	}
