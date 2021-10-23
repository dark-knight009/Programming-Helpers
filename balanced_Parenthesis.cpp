#include <iostream>
#include<bits/stdc++.h>
using namespace std;

int main() {
	stack<char> st;
	string s;
	cin>>s;
	int i=0;
	int n = s.length();
	while(i<n){
	    if(s[i] == '(' || s[i] == '[' || s[i] == '{') st.push(s[i]);
	    else if (s[i] == ')' || s[i] == '}' || s[i] == ']') {
	        if(st.empty()) {
	            cout<<"Empty stack"<<endl;
	            break;
	        }
	        char ch = st.top();
	        st.pop();
	        
	        if((s[i] == '(' && ch !=')') || (s[i] == '[' && ch!=']') || (s[i] == '{' && ch!='}')) {
	            cout<<"Not Balanced"<<endl;
	        }
	        
	        
	    }
	    i++;
	}
	
	if(st.empty()) cout<<"Balanced "<<endl;
	else cout<<"NOT Balanced"<<endl;
	return 0;
}