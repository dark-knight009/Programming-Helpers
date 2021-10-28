#include<bits/stdc++.h>
using namespace std;

int main() {
    int n, flag;
    cin >> n;
    
    int arr[n];
    for(int i=0; i<n; i++) {
        cin >> arr[i];
    }
    
    for(int i=0; i<n; i++) {
       int flag = 0;
       for(int j=0; j<n-i-1; j++) {
           if(arr[j] > arr[j+1]) {
               swap(arr[j], arr[j+1]);
               flag++;
           }
       }
       if(flag == 0)
        break;
    }
    
    for(int i=0; i<n; i++) {
        cout << arr[i] << " ";
    }
}
