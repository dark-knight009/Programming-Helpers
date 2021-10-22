#include<iostream>
using namespace std;
#include<bits/stdc++.h>

int main(){
	string s,t,p;
	cin>>s>>t;
	int n=s.length();
	int count=0;
	for(int i=0;i<n;i++){
		p=s.substr(i,t.length());
		if(p==t)
		count++;
	}
	cout<<count;
	return 0;
}
