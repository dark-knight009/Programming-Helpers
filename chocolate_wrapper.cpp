#include<iostream>
#include<bits/stdc++.h>
using namespace std;

int countchoco(int m,int p,int w){
	int choc=m/p;
	choc=choc+(choc-1)/(w-1);
	return choc;
}

int main(){
	int m,p,w;
	cin>>m>>p>>w;
	cout<<countchoco(m,p,w);
}
