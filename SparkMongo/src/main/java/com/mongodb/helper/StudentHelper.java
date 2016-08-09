package com.mongodb.helper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.mongodb.student.model.Semester;
import com.mongodb.student.model.StudentDetailModel;
import com.mongodb.student.model.SubjectModel;

public class StudentHelper {

	public static void main(String[] args) {

		
	}

	
	public static List<StudentDetailModel> populateStudentDetails(){
		
		List<StudentDetailModel> students=new ArrayList<StudentDetailModel>();
		StudentDetailModel model=null;
		
		for(int i=0;i<15;i++){
			model=new StudentDetailModel("AA"+i, i, (i%2==0 ?"CSE" :"ECE"));
			
			model.setSemesters(populateSemesterDetails());
			
			students.add(model);
		}
      
		return students;
	}


	private static List<Semester> populateSemesterDetails() {
		List<Semester> semesters=new ArrayList<Semester>();
		Semester semester=null;
		for(int i=1;i<8;i++){
			semester=new Semester(i);
			semester.setSubjectModels(populateSubjectDetails());
			semesters.add(semester);
		}
		
		return semesters;
	}


	private static List<SubjectModel> populateSubjectDetails() {
		SubjectModel subjectModel=null;
		List<SubjectModel> subjectModels=new ArrayList<SubjectModel>();
		
		for(int i=1;i<6;i++){
			subjectModel=new SubjectModel("SUBJECT"+i, Math.random());
			subjectModels.add(subjectModel);
		}
		
		return subjectModels;
	}
	


	public static <T> Map<String, Object> toKeyValuePairs(Object instance,
			Class<T> class1) {

		return Arrays.stream(class1.getDeclaredMethods())
        .filter(p -> !p.getName().startsWith("set"))
        .filter(p -> !p.getName().startsWith("getClass"))
        .filter(p -> !p.getName().startsWith("setClass"))
        .collect(Collectors.toMap(
                d -> d.getName().substring(3),
                m -> {
                    try {
                        Object result = m.invoke(instance);
                        return result;
                    } catch (Exception e) {
                        return "";
                    }
                }, (p1, p2) -> p1)
        );
	}

}
