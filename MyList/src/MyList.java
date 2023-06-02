public class MyList<T>{
    T [] arr;
    int capacity;
    public  MyList(){
        this.capacity=10;
        arr=(T[]) new Object[capacity];
    }
    public MyList(int size){
        capacity=size;
        arr=(T[]) new Object[capacity];
    }

    public int size(){
        int count=0;
        for(T i :arr){
            if(i !=null ){
                count++;
            }
        }
        return count;
    }
    public int getCapacity(){
        return this.capacity;
    }
    public void add(T data){

        if(this.size()==this.getCapacity())
        {
            this.capacity=capacity*2;
            T [] newArr= (T[]) new Object[capacity];
            for (int i = 0; i < arr.length ; i++) {
                newArr[i]=arr[i];
            }
            newArr[arr.length] = data;
            this.arr=newArr;

        }
        else{
            arr[this.size()]=data;

        }
    }
    public T get(int index) {
        if(index < 0 || index >= size()) return null;
        return arr[index];
    }

    public T remove(int index){
        if(index>this.getCapacity()||index<0){
            return null ;
        }
        T removed=this.arr[index];
        for(int i=index;i< arr.length-1;i++){
            this.arr[i]=this.arr[i+1];
        }
        this.arr[arr.length-1]=null;
        return  removed;

    }
    public void set(int index ,T data){
        if(index < 0 || index >= size()){
            return;
        }
        this.arr[index]=data;
    }
    public String toString(){
        String str="";
        for(int i=0;i<this.arr.length;i++){
            if(this.arr[i]!=null){
                str+=this.arr[i]+" ";
            }
        }
        return str;
    }

    public int indexOf(T data){
        for (int i = 0; i <this.arr.length ; i++) {
            if(arr[i]==data){
                return i;
            }
        }
        return -1;
    }

    public int lastIndexOf(T data){
        for (int i = this.arr.length-1; i>=0; i--) {
            if(arr[i]==data){
                return i;

            }
        }
        return -1;
    }
    public boolean  isEmpty(){
        if(this.size()>0){
            return false;
        }else {
            return true;
        }

    }
    public T []toArray(){
        T [] newlist= (T[]) new Object[getCapacity()];
        for (int i = 0; i <this.arr.length ; i++) {
            newlist[i]=this.arr[i];
        }
        return newlist;
    }

    public void clear(){
        for(int i=0;i<this.arr.length;i++){
            this.arr[i]=null;
        }
    }
    public MyList <T> subList(int start,int finish){
        int size=finish+1-start;
        MyList <T> myNewList =new MyList<>(size);
        int j=0;
        for (int i = start; i <=finish ; i++) {
            myNewList.add(arr[i]);
        }
        return myNewList;
    }
    public boolean contains(T data) {
        for (int i = 0; i < size(); i++) {
            if(data.equals(arr[i])) return true;
        }
        return false;
    }

}