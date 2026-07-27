package service;

import model.Task;

import java.util.ArrayList;

public class Task_service {
    public static void Add(ArrayList<Task> List,Task element){
        List.add(element);
    }

    public static void Removal(ArrayList<Task> List, String title){
        List.removeIf(element -> element.getTask_name().equals(title));



    }

    public static boolean checking(ArrayList<Task> List, String title){
        boolean state = false;
        for(Task name:List){
            if(name.getTask_name().equals(title)){
                state=true;
                break;
            }
        }
        return state;
    }


    public static void change_state(ArrayList<Task> List, String compare){
        for(Task name:List){
            if(name.getTask_name().equals(compare)){
                name.setTask_state(!name.isTask_state());
                break;
            }
        }
    }

    public static void modifyName(ArrayList<Task> List, String compare, String mod){
        for(Task name:List){
            if(name.getTask_name().equals(compare)){
                name.setTask_name(mod);
                break;
            }
        }
    }




    public static void Modify_date(ArrayList<Task> List, String compare, int mod){
        for(Task name:List){
            if(name.getTask_name().equals(compare)){
                name.setTime_to_finish(mod);
                break;
            }
        }
    }






}
