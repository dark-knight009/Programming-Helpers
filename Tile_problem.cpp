//Big floor is given of 2xn length and tile if 2x1 is to be put on it in horizontal or vertical order find the ways in which tile can be put on floor
#include<iostream>
#include<bits/stdc++.h>
using namespace std;

int counttile(int n){
	if(n==0)
	return 0;
	
	if(n==1)
	return 1;
	
	return counttile(n-1)+counttile(n-2);
	
}


int main(){
	int n;
	cin>>n;
int p=counttile(n);
cout<<p;
}
