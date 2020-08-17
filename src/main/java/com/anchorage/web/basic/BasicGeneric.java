package com.anchorage.web.basic;
class BasicGenericMain {
    public static void main(String[] args) {
        BasicGenericService service = new BasicGenericServiceImpl<String>();
        System.out.println(service.print("Hello Generic !!"));
    }
}
class BasicGeneric<T> {
    private T val;

    public BasicGeneric(T val) {
        this.val = val;
    }
    public T getVal() {
        return val;
    }
    public void setVal(T val) {
        this.val = val;
    }
}
interface BasicGenericService {
    String print(String param);
}
class BasicGenericServiceImpl<T> implements BasicGenericService{
    @Override
    public String print(String param) {
        BasicGeneric<?> g = new BasicGeneric<String>(param);
        return (String) g.getVal();
    }
}

