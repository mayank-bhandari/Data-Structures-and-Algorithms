#include <iostream>
#include <random>

using namespace std;

//return index if number is found else -1
int my_binary_search(int A[], int num, int first, int last){

    int mid = 0;

    while(last>=first){

        mid = first + (last-first)/2;
        if(A[mid]==num){
            return mid;
        }else{
            if(A[mid]>num){
                last = mid-1;
            }else{
                first = mid+1;
            }
        }
    }
    return -1;
}

// initialize array in a sorted order, with num_elements integers
void initialize_array_sorted(int A[], int num_elements){
    A[0] = rand()%10000007;
    for(int i =1;i<num_elements;i++){
        A[i] = A[i-1] + rand()%10000007;
    }
    return;
}

void print(int A[], int n){
    for(int i =0; i <n;i++){
        cout<<i<<" "<<A[i]<<endl;
    }
    return;
}

int main()
{
    int A[1000];
    int num_elements = 100, x = 0;

    initialize_array_sorted(A, 100);

    cout<<my_binary_search(A, A[99]+1000, 0, 99)<<endl;
    x = A[rand()%100];
    cout<<"X : "<<x<<" found at index : "<<my_binary_search(A, x, 0, 99)<<endl;
    print(A, 100);
    return 0;
}
