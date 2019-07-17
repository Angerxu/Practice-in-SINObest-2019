class MaxHeapSort
{
    public static void main(String[] args) {
        int[] arr = {1, 5, 6, 8, 7, 2, 3, 4, 9};

        HeapSort(arr);
        for(int i = 0;i < arr.length;i++) {
            System.out.print(arr[i] + "  ");
        }
    }
    /*堆排序函数*/
    public static void HeapSort(int[] arr)
    {
        int n = arr.length-1;
        for(int i=(n - 1) / 2;i >= 0;i--)
        {
            // 构造大顶堆，从下往上构造，先构造左半部分
            HeapAdjust(arr, i, n);
        }
        for(int i = n;i > 0;i--)
        {
            // 再构造右半部分，最大数在最后
            swap(arr, i);
            HeapAdjust(arr, 0, i-1);
        }
    }

    // 构造大顶堆函数，parent为父节点，length为数组最后一个元素的下标
    public static void HeapAdjust(int[] arr, int parent, int length)
    {
        int temp = arr[parent];
        for(int i = parent * 2 + 1;i <= length;i = i * 2 + 1) {
            if (i < length && arr[i] < arr[i + 1]) {
                i++;
            }
            if(temp >= arr[i]) {
                break;
            }

            arr[parent] = arr[i];
            parent = i;
        }
        arr[parent] = temp;
    }

    /*定义swap函数*/
    public static void swap(int[] arr, int i)
    {
        int temp = arr[0];
        arr[0] = arr[i];
        arr[i] = temp;
    }
}
