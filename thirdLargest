class Solution
{
    int thirdLargest(int a[], int n)
    {
        quickSort(a, 0, n-1);
        return a[n - 3];
    }
    
    private void quickSort(int a[], int low, int high) {
        
        if (low >= high) {
            return;
        }
        
        int pivotIndex = new Random().nextInt(high - low) + low;
        int pivot = a[pivotIndex];
        swap(a, pivotIndex, high);
        
        int left = low;
        int right = high;
        
        while (left < right) {
            while (a[left] <= pivot && left < right) {
                left++;
            }
            
            while (a[right] >= pivot && left < right) {
                right--;
            }
            
            swap(a, left, right);
        }
        
        swap(a, left, high);
        
        quickSort(a, low, left-1);
        quickSort(a, left+1, high);
    }
    
    private void swap(int a[], int index1, int index2) {
        int temp = a[index1];
        a[index1] = a[index2];
        a[index2] = temp;
    }
}
