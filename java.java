import java.io.*;
class MultitudeElement {
    MultitudeElement next;
    int data;
}
class List {
    MultitudeElement []head=new MultitudeElement[0];       
    String []name=new String[10];
    int exists;
    void addMulti(String namea){
            if(this.exists==0){
                    this.name=new String[exists+1];
                    this.name[this.exists]=namea;
                    this.head=new MultitudeElement[exists+1];
                    this.exists++;
            }else{
                    int exflag=0;
                     MultitudeElement []bufhead=new MultitudeElement[exists];
                     String []namebuf=new String[exists];
                     bufhead=head;
                     namebuf=name;
                    for(int i=0;i<this.exists;i++){
                            if(namea.compareTo(this.name[i])==0){
                                            exflag=1;
                                    break;
                            }                            
                    }
                    if(exflag==1){

                    }else{
                            head=new MultitudeElement[exists+1];
                            name=new String[exists+1];
                            name[exists]=namea;
                            exists++;
                            for(int i=0;i<(exists-1);i++){
                                    name[i]=namebuf[i];
                                    head[i]=bufhead[i];
                            }
                    }
            }
    }
    void delMulti(String nametd){
                    Integer path=-1;
            for(int i=0;i<exists;i++){
                    if(nametd.compareTo(name[i])==0){
                            path=i;
                    }
            }
            if(path==-1){

            }else{
                    MultitudeElement []bufhead=new MultitudeElement[exists-1];
                            String []namebuf=new String[exists-1];
                            int m=0;
                    for(int i=0;i<exists;i++){
                            if(i==path){
                                    head[i]=null;
                                    name[i]=null;
                                    m=1;
                            }else{
                                    namebuf[i-m]=name[i];
                                    bufhead[i-m]=head[i];
                            }
                    }
                    exists--;
                    name=new String[exists];
                    head=new MultitudeElement[exists];
                    for(int i=0;i<exists;i++){
                            name[i]=namebuf[i];
                            head[i]=bufhead[i];
                    }
            }
            }
    void addElement(int toadd,String namea){
            Integer path=-1;
           for(int i=0;i<exists;i++){
                   if(namea.compareTo(name[i])==0){
                           path=i;
                   }
           }
           if(path==-1){

           }else{
                   if(head[path]!=null){ //without head?
                                                   if(head[path].next==null){ //next existing
                                                           if(head[path].data==toadd){

                                                           }else{
                                                                   if(head[path].data>toadd){ // if head bigger then value
                                                                           MultitudeElement p=new MultitudeElement();
                                                                           p.next=head[path];
                                                                           p.data=toadd;
                                                                           head[path]=p;
                                                                   }else{ //if head smaller then value
                                                                           head[path].next=new MultitudeElement();
                                                                           head[path].next.data=toadd;
                                                                   }
                                                           }
                                                   }else{
                                                           if(head[path].next.data==toadd||head[path].data==toadd){ // existing value
                                                                   //nothing to do
                                                           }else{
                                                                   MultitudeElement p=new MultitudeElement();
                                                                   p=head[path];
                                                                   if(p.data>toadd){
                                                                           MultitudeElement b=new MultitudeElement();
                                                                           b.data=toadd;
                                                                           b.next=head[path];
                                                                           head[path]=b;
                                                                   }else{
                                                                           while(p.next!=null&&p.next.data<toadd){//run to end
                                                                                           p=p.next;
                                                                           }
                                                                           if(p.next==null){// if it end of multitude
                                                                                   if(p.data==toadd){

                                                                                   }else{
                                                                                   p.next=new MultitudeElement();
                                                                                   p.next.data=toadd;
                                                                                   }
                                                                           }else{//if p.next.data bigger then value
                                                                                   if(p.next.data==toadd){

                                                                                   }else{
                                                                                   MultitudeElement b=new MultitudeElement();
                                                                                   b.data=toadd;
                                                                                   b.next=p.next;
                                                                                   p.next=b;
                                                                                   }
                                                                           }
                                                                   }
                                                           }
                                                   }
                   }else{
                           head[path]=new MultitudeElement();
                           head[path].data=toadd;
                           head[path].next=null;
                   }
           }
        }
    void delElement(int todel,String nametd){
            Integer path=-1;
        for(int i=0;i<exists;i++){
                if(nametd.compareTo(name[i])==0){
                        path=i;
                }
        }
        if(path!=-1){
                if(head[path]!=null){
                        if(head[path].data==todel){ // if delete first
                                head[path]=head[path].next;
                        }else{
                                if(head[path].next.data==todel){// second
                                        head[path].next=head[path].next.next;
                                }else{
                                        if(head[path].next.next!=null){
                                                       MultitudeElement p=new MultitudeElement();
                                                       p=head[path];
                                                       while(p.next.next!=null&&p.next.next.data!=todel){
                                                               p=p.next;
                                                       }
                                                       if(p.next.next==null){//if todel not exist in multitude
                                                               //nothing to do
                                                       }else{
                                                                       p.next.next=p.next.next.next;
                                                       }
                                        }
                                }
                        }
                }else{

                     }

             }else{
        }
    }
    void show(String namea){
           Integer path=-1;
       for(int i=0;i<exists;i++){
               if(namea.compareTo(name[i])==0){
                       path=i;
               }
       }
       if(path!=-1){
                    MultitudeElement t = head[path];
                    System.out.print(namea+"=");
                while (t != null){
                        if(t==head[path]){
                                System.out.print("{\"" + t.data + "\",");
                                t=t.next;
                        }
                        if(t.next!=null){
                    System.out.print(t.data + "\",\"");
                        }
                        if(t.next==null){
                                System.out.println(t.data + "\"}");
                        }
                    t = t.next;
                }
       }
    }
    void showAll(){
            for(int i=0;i<exists;i++){
                    show(name[i]);
            }
    }
    void union(String multi[]){
            Integer path=-1,path2=-1,path3=-1;
        for(int i=0;i<exists;i++){
                if(multi[0].compareTo(name[i])==0){
                        path=i;
                }
        }
        for(int i=0;i<exists;i++){
                 if(multi[1].compareTo(name[i])==0){
                         path2=i;
                 }
        }
        if(path>=0&&path2>=0){
                    if(multi.length==3){
                            for(int i=0;i<exists;i++){
                                     if(multi[2].compareTo(name[i])==0){
                                             path3=i;
                                     }
                            }
                            if(path3>=0){
                                    head[path3]=null;
                            }else{
                                    addMulti(multi[2]);
                            }

                                    MultitudeElement p=new MultitudeElement();
                                    MultitudeElement b=new MultitudeElement();
                                    p=head[path];
                                    b=head[path2];
                                    while(p!=null||b!=null){
                                                    if(p==null||b==null){
                                                            if(p==null){
                                                                    addElement(b.data,multi[2]);
                                                                    b=b.next;
                                                            }else{
                                                                    addElement(p.data,multi[2]);
                                                                    p=p.next;
                                                            }
                                                    }else{
                                                    if(p.data<b.data){
                                                            addElement(p.data,multi[2]);
                                                            p=p.next;
                                                    }else{
                                                            if(p.data>b.data){
                                                                    addElement(b.data,multi[2]);
                                                                    b=b.next;
                                                            }else{
                                                                    addElement(p.data,multi[2]);
                                                                    p=p.next;
                                                                    b=b.next;
                                                            }
                                                    }
                                                    }
                                            }
                                                    show(multi[2]);

                            }else{
                            addMulti("res");
                            MultitudeElement p=new MultitudeElement();
                            MultitudeElement b=new MultitudeElement();
                            p=head[path];
                            b=head[path2];
                            while(p!=null||b!=null){
                                    if(p==null||b==null){
                                            if(p==null){
                                                    addElement(b.data,"res");
                                                    b=b.next;
                                            }else{
                                                    addElement(p.data,"res");
                                                    p=p.next;
                                            }
                                    }else{
                                    if(p.data<b.data){
                                            addElement(p.data,"res");
                                            p=p.next;
                                    }else{
                                            if(p.data>b.data){
                                                    addElement(b.data,"res");
                                                    b=b.next;
                                            }else{
                                                    addElement(p.data,"res");
                                                    p=p.next;
                                                    b=b.next;
                                            }
                                    }
                                    }
                            }
                            show("res");
                            delMulti("res");
                    }
         }else{
         }
    }
    void existM(String nameex){
            Integer path=-1;
        for(int i=0;i<exists;i++){
                if(nameex.compareTo(name[i])==0){
                        path=i;
                }
        }
        if(path==-1){
                System.out.println("Не существует множества \""+nameex+"\".");
        }else{
                System.out.println("Множество \""+nameex+"\" существует.");
        }
    }
    void isinElement(int element,String multi){
            Integer path=-1;
        for(int i=0;i<exists;i++){
                if(multi.compareTo(name[i])==0){
                        path=i;
                }
        }
        if(path==-1){
        }else{
                MultitudeElement p=new MultitudeElement();
                p=head[path];
                if(p!=null){
                        if(p.next==null){
                                if(p.data==element){
                                        System.out.println("Элемент "+"\""+element+"\""+" есть в \""+multi+"\"");
                                }else{
                                        System.out.println("Элемент "+"\""+element+"\""+" не имеется в \""+multi+"\"");
                                }
                        }else{
                                while(p.next!=null&&p.data!=element){
                                        p=p.next;
                                }
                                if(p.data==element){
                                        System.out.println("Элемент "+"\""+element+"\""+" есть в \""+multi+"\"");
                                }else{
                                        System.out.println("Элемент "+"\""+element+"\""+" не имеется в \""+multi+"\"");
                                }
                        }
                }else{

                }
        }
    }
    void isinMultitude(String []names){
            Integer path=-1,path2=-1;
        for(int i=0;i<exists;i++){
                if(names[0].compareTo(name[i])==0){
                        path=i;
                }
        }
        for(int i=0;i<exists;i++){
                 if(names[1].compareTo(name[i])==0){
                         path2=i;
                 }
         }
        if(path>=0&&path2>=0){
                    if(path==path2){
                            System.out.println("Оба аргумента являются одним и тем же множеством");
                    }else{
                            MultitudeElement p=new MultitudeElement();
                            MultitudeElement b=new MultitudeElement();
                            p=head[path];
                            b=head[path2];
                            if(p==null||b==null){
                                    if(p==null){
                                            System.out.println("Да, "+name[path]+" содержится в "+name[path2]);
                                    }else{
                                            if(p!=b){
                                                    System.out.println("Да, "+name[path]+" содержится в "+name[path2]);
                                            }else{
                                                    System.out.println("Оба аргумента являются пустым множеством");
                                            }
                                    }
                            }else{
                                    while(p.next!=null&&b.next!=null){
                                            if(p.data>b.data){
                                                    b=b.next;
                                            }
                                            if(p.data==b.data){
                                                    p=p.next;
                                                    b=b.next;
                                            }
                                            if(p.data<b.data){
                                                    System.out.println("Нет, "+name[path]+" не содержится в "+name[path2]);
                                                    break;
                                            }
                                    }
                                    if(p.next==null){
                                            System.out.println("Да, "+name[path]+" содержится в "+name[path2]);
                                    }else{
                                            System.out.println("Нет, "+name[path]+" не содержится в "+name[path2]);
                                    }
                            }
                    }
        }else{
                System.out.println("Одного из заданных множеств не существует");
        }
    }
    void intersecM(String []multi){
            Integer path=-1,path2=-1,path3=-1;
        for(int i=0;i<exists;i++){
                if(multi[0].compareTo(name[i])==0){
                        path=i;
                }
        }
        for(int i=0;i<exists;i++){
                 if(multi[1].compareTo(name[i])==0){
                         path2=i;
                 }
        }
        if(path>=0&&path2>=0){
                    if(multi.length==3){
                            for(int i=0;i<exists;i++){
                                     if(multi[2].compareTo(name[i])==0){
                                             path3=i;
                                     }
                            }
                            if(path3>=0){
                                    head[path3]=null;
                            }else{
                                    addMulti(multi[2]);
                            }

                                    MultitudeElement p=new MultitudeElement();
                                    MultitudeElement b=new MultitudeElement();
                                    p=head[path];
                                    b=head[path2];
                                    while(p!=null&&b!=null){
                                                    if(p.data<b.data){
                                                            p=p.next;
                                                    }else{
                                                            if(p.data>b.data){
                                                                    b=b.next;
                                                            }else{
                                                                    addElement(p.data,multi[2]);
                                                                    p=p.next;
                                                                    b=b.next;
                                                            }
                                                    }
                                            }
                                                    show(multi[2]);

                            }else{
                            addMulti("res");
                            MultitudeElement p=new MultitudeElement();
                            MultitudeElement b=new MultitudeElement();
                            p=head[path];
                            b=head[path2];
                            while(p!=null&&b!=null){
                                    if(p.data<b.data){
                                            p=p.next;
                                    }else{
                                            if(p.data>b.data){
                                                    b=b.next;
                                            }else{
                                                    addElement(p.data,"res");
                                                    p=p.next;
                                                    b=b.next;
                                            }
                                    }
                            }
                            show("res");
                            delMulti("res");
                    }
         }else{

        }
    }
    void diffM(String []multi){
            Integer path=-1,path2=-1,path3=-1;
            MultitudeElement buf=new MultitudeElement();
            for(int i=0;i<exists;i++){
                 if(multi[0].compareTo(name[i])==0){
                         path=i;
                 }
         }
         for(int i=0;i<exists;i++){
                  if(multi[1].compareTo(name[i])==0){
                          path2=i;
                  }
         }
            if(multi.length==3){
                    for(int i=0;i<exists;i++){
                     if(multi[2].compareTo(name[i])==0){
                             path3=i;
                     }
             }
                    if(path3==-1){
                    }else{
                            if(path3==path){
                                    buf=head[path3];
                            }
                            head[path3]=null;
                    }
                    addMulti(multi[2]);
                    if(path>=0&&path2>=0){
                    MultitudeElement p=new MultitudeElement();
                    MultitudeElement b=new MultitudeElement();
                    p=buf;
                    b=head[path2];
                    while(p.next!=null&&b.next!=null){
                            if(b.next==null){
                                    addElement(p.data, multi[2]);
                                    p=p.next;
                            }else{
                                    if(p.data<b.data){
                                            addElement(p.data, multi[2]);
                                            p=p.next;
                                    }else{
                                            if(p.data>b.data){
                                                    b=b.next;
                                            }else{
                                                    b=b.next;
                                                    p=p.next;
                                            }
                                    }
                            }



                    }
                    show(multi[2]);
                    delMulti(multi[2]);
                    }
            }else{

            for(int i=0;i<exists;i++){
                    if(multi[0].compareTo(name[i])==0){
                            path=i;
                    }
            }
            for(int i=0;i<exists;i++){
                     if(multi[1].compareTo(name[i])==0){
                             path2=i;
                     }
            }
            if(path>=0&&path2>=0){
                    addMulti("res");
                    MultitudeElement p=new MultitudeElement();
                    MultitudeElement b=new MultitudeElement();
                    p=head[path];
                    b=head[path2];
                    while(p.next!=null&&b.next!=null){
                            if(b.next==null){
                                    addElement(p.data, "res");
                                    p=p.next;
                            }else{
                                    if(p.data<b.data){
                                            addElement(p.data, "res");
                                            p=p.next;
                                    }else{
                                            if(p.data>b.data){
                                                    b=b.next;
                                            }else{
                                                    b=b.next;
                                                    p=p.next;
                                            }
                                    }
                            }



                    }
                    show("res");
                    delMulti("res");
            }
            }
    }
    void simdiff(String multi[]){
              Integer path=-1,path2=-1,path3=-1;
          for(int i=0;i<exists;i++){
                  if(multi[0].compareTo(name[i])==0){
                          path=i;
                  }
          }
          for(int i=0;i<exists;i++){
                   if(multi[1].compareTo(name[i])==0){
                           path2=i;
                   }
          }
          if(path>=0&&path2>=0){
                      if(multi.length==3){
                              for(int i=0;i<exists;i++){
                                       if(multi[2].compareTo(name[i])==0){
                                               path3=i;
                                       }
                              }
                              if(path3>=0){
                                      head[path3]=null;
                              }else{
                                      addMulti(multi[2]);
                              }

                                      MultitudeElement p=new MultitudeElement();
                                      MultitudeElement b=new MultitudeElement();
                                      p=head[path];
                                      b=head[path2];
                                      while(p!=null||b!=null){
                                                      if(p==null||b==null){
                                                              if(p==null){
                                                                      addElement(b.data,multi[2]);
                                                                      b=b.next;
                                                              }else{
                                                                      addElement(p.data,multi[2]);
                                                                      p=p.next;
                                                              }
                                                      }else{
                                                      if(p.data<b.data){
                                                              addElement(p.data,multi[2]);
                                                              p=p.next;
                                                      }else{
                                                              if(p.data>b.data){
                                                                      addElement(b.data,multi[2]);
                                                                      b=b.next;
                                                              }else{
                                                                      p=p.next;
                                                                      b=b.next;
                                                              }
                                                      }
                                                      }
                                              }
                                                      show(multi[2]);

                              }else{
                              addMulti("res");
                              MultitudeElement p=new MultitudeElement();
                              MultitudeElement b=new MultitudeElement();
                              p=head[path];
                              b=head[path2];
                              while(p!=null||b!=null){
                                      if(p==null||b==null){
                                              if(p==null){
                                                      addElement(b.data,"res");
                                                      b=b.next;
                                              }else{
                                                      addElement(p.data,"res");
                                                      p=p.next;
                                              }
                                      }else{
                                      if(p.data<b.data){
                                              addElement(p.data,"res");
                                              p=p.next;
                                      }else{
                                              if(p.data>b.data){
                                                      addElement(b.data,"res");
                                                      b=b.next;
                                              }else{
                                                      p=p.next;
                                                      b=b.next;
                                              }
                                      }
                                      }
                              }
                              show("res");
                              delMulti("res");
                      }
           }else{
           }
    }
}
public class main {
        public static void main(String args[]) throws IOException{
                List mylist=new List();
                mylist.exists=0;
                BufferedReader reader = new BufferedReader(new FileReader("/home/dart_revan/JavaApp/DM/bin/file.txt"));
                String line;
                while((line = reader.readLine()) != null){
                        reader.mark(0);
                        reader.reset();
                        System.out.println(line);
                                if(line.startsWith("new")){//new multitude
                                String nameadd=line.substring(4);
                                mylist.addMulti(nameadd);
                                }
                                if(line.startsWith("add")){//add element
                                int cx=0,el;
                                cx=line.indexOf(' ', 4);
                                String nameadd=line.substring(4,cx);
                                cx++;
                                el=Integer.parseInt(line.substring(cx)) ;
                                mylist.addElement(el,nameadd);
                                }
                                if(line.startsWith("exit")){//exit programm
                                        break;
                                }
                                if(line.startsWith("del")){//del
                                        if(mylist.exists==0){
                                                int cx=line.indexOf(' ', 4),el;
                                                if(cx<0){//del multitude
                                                        String nametodel=line.substring(4);
                                                        mylist.delMulti(nametodel);

                                                }else{//delelement
                                                    String nametodel=line.substring(4,cx);
                                                    cx++;
                                                    el=Integer.parseInt(line.substring(cx));
                                                    mylist.delElement(el,nametodel);
                                                }
                                        }
                                }
                                if(line.startsWith("show")){// show
                                        if(line.compareTo("show")==1){//single show
                                    String nameshow=line.substring(5);
                                    mylist.show(nameshow);
                                        }else{ //show all
                                                mylist.showAll();
                                         }
                                }
                                if(line.startsWith("union")){ //union
                                        String []z;
                                        line=line.substring(6);
                                        z=line.split(" ");
                                        mylist.union(z);
                                }
                                if(line.startsWith("simmdiff")){ //simdiff
                                    String []z;
                                    line=line.substring(9);
                                    z=line.split(" ");
                                    mylist.union(z);
                                }
                                if(line.startsWith("intersec")){ //intersec
                                        String []z;
                                        line=line.substring(9);
                                        z=line.split(" ");
                                        mylist.intersecM(z);
                                }
                                if(line.startsWith("exist")){ // existing
                                        line=line.substring(6);
                                        if(mylist.exists!=0){
                                        mylist.existM(line);
                                        }
                                }
                                if(line.startsWith("diff")){ //"-"
                                        String []z;
                                        line=line.substring(5);
                                        z=line.split(" ");
                                        mylist.diffM(z);
                                }
                                if(line.startsWith("Isin")){ //multi in multi?
                                        String []z;
                                        line=line.substring(5);
                                        z=line.split(" ");
                                        mylist.isinMultitude(z);
                                }
                                if(line.startsWith("isin")){//element in multi
                                        int cx=line.indexOf(' ', 5);
                                        mylist.isinElement(Integer.parseInt(line.substring(5, cx)),line.substring(cx+1));
                                }
                        }
        }

}
