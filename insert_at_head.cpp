#include<iostream>
#include<bits/stdc++.h>
using namespace std;


struct node{
	int data;
	node* next;
	
	node(int val){
		data=val;
		node* next=NULL;
	}
};



void at_end(node* &head,int val){
	node* n=new node(val);
	if(head==NULL){
		head=n;
		return;
	}
	
	n->next=head;
	head=n;
	
	
}


void print(node* head){
	node* temp=head;
	while(temp!=NULL){
		cout<<temp->data<<" ";
		temp=temp->next;
	}
}

int main(){
	node* head;
	
	at_end(head,1);
	at_end(head,2);
	at_end(head,3);
	print(head);
	return 0;
	
}
