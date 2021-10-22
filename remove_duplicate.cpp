	string removeDups(string S) 
	{
	    string k;
	    map<char,int>mappi;
	    int n=S.length();
	    for(int i=0;i<n;i++){
	        if(mappi.find(S[i])==mappi.end()){
	            k.push_back(S[i]);
	            mappi[S[i]]=i;
	            
	        }
	    }
	    return k;
	    
	    
	    
	
	    // Your code goes here
	}
	
