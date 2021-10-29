#include<bits/stdc++.h>
using namespace std;

int linear(int arr[], int n, int x) {
    
    if(n>=0) {
        if(arr[n-1] == x)
            return n-1;
        else
            return linear(arr, n-1, x);
    }
    return -1;
}

int main() {
    int n, search, res=0;
    cin >> n;
    
    int arr[n];
    for(int i=0; i<n; i++) {
        cin >> arr[i];
    }
    
    cin >> search;
    
    res = linear(arr, n, search);
    cout << res;
}
