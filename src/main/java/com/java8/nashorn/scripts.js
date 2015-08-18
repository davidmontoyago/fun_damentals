function sumSomething() {
    var list = new java.util.ArrayList();

    list.add(1);
    list.add(3);
    list.add(4);
    list.add(5);
    list.add(7);
    list.add(9);
    list.add(11);
    list.add(21);
    list.add(48);

    return list.stream().mapToInt(function(i) { return i*i; }).sum();
}