package com.cg.bankapp.practice;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamsApi {

    public static void main(String[] args) {


        int[] num=new int[]{1,3,2,3,1};
        List<Integer> li=Arrays.stream(num).boxed().collect(Collectors.toList());
        li=li.stream().map(n -> {
            if(n%2==0) return n*2;
            else return n;
        }).toList();
        System.out.println(li);

        List<Integer> nums = Arrays.asList(
                10, 5, 20, 15, 30, 25, 10, 5
        );
        nums.stream().filter(n -> n>15).forEach(System.out::println);
        List<Integer> nums2;
        nums2=nums.stream().map(n -> n*n ).toList();
        System.out.println(nums2);

        nums2=nums.stream().filter(n -> n%2==0).toList();
        System.out.println(nums2);

        nums2=nums.stream().filter(n -> n%2!=0 && n>10).toList();
        System.out.println(nums2);

        List<String> nums3=nums.stream().map(String::valueOf).toList();
        System.out.println(nums3);

        long count=nums.stream().filter(n -> n>10).count();
        System.out.println(count);

        nums2=nums.stream().distinct().toList();
        System.out.println(nums2);

        nums2=nums.stream().sorted().toList();
        System.out.println(nums2);

        nums2=nums.stream().sorted(Collections.reverseOrder()).toList();
        System.out.println(nums2);

        nums2=nums.stream().distinct().sorted(Collections.reverseOrder()).limit(3).toList();
        System.out.println(nums2);

        nums2=nums.stream().skip(3).toList();
        System.out.println(nums2);

        Optional<Integer> n=nums.stream().distinct().sorted(Collections.reverseOrder()).skip(1).findFirst();
        System.out.println(n.orElse(-1));

        Optional<Integer> sum=nums.stream().reduce(Integer::sum);
        System.out.println(sum.orElse(-1));

        Optional<Integer> prod=nums.stream().reduce((a,b) -> a*b);
        System.out.println(prod.orElse(-1));

        Optional<Integer> max=nums.stream().reduce(Math::max);
        System.out.println(max.orElse(-1));

        Optional<Integer> min=nums.stream().reduce(Math::min);
        System.out.println(min.orElse(-1));

        n=nums.stream().filter(a -> a%2==0).map(a -> a*a).reduce(Integer::sum);
        System.out.println(n.orElse(-1));

        boolean b=nums.stream().anyMatch( a -> a>50);
        System.out.println(b);

        b=nums.stream().allMatch( a -> a>0);
        System.out.println(b);

        b=nums.stream().noneMatch( a -> a<0);
        System.out.println(b);

        List<String> names =
                Arrays.asList("Aniket", "Rahul", "Aman", "Rohit");
        b=names.stream().anyMatch( str -> str.startsWith("A"));
        System.out.println(b);

        n=nums.stream().filter( a -> a>15 ).findFirst();
        System.out.println(n.orElse(-1));

        n=nums.stream().filter( a -> a%2==0 ).findFirst();
        System.out.println(n.orElse(-1));

        n=nums.stream().filter( a -> a>100 ).findFirst();
        System.out.println(n.orElse(-1));

        Optional<String> result=names.stream().filter( str -> str.startsWith("Z")).findFirst();
        System.out.println(result.orElse("Not Found"));

        names = Arrays.asList(
                "Aniket",
                "Rahul",
                "Aman",
                "Rohit",
                "Amit",
                "Raj",
                "Ankit"
        );

        List<String> resultName=names.stream().filter(str -> str.length()>4).toList();
        System.out.println(resultName);

        resultName=names.stream().map(String::toUpperCase).toList();
        System.out.println(resultName);

        resultName=names.stream().sorted().toList();
        System.out.println(resultName);

        resultName=names.stream().sorted((a,c) -> Integer.compare(a.length(), c.length())).toList();
        System.out.println(resultName);

        result = names.stream().sorted((a,c) -> Integer.compare(a.length(), c.length())).findFirst();
        System.out.println(result.orElse("Not Found"));

        result = names.stream().sorted((a,c) -> Integer.compare(c.length(), a.length())).findFirst();
        System.out.println(result.orElse("Not Found"));

        count =names.stream().filter( str -> str.startsWith("A")).count();
        System.out.println(count);

        resultName=names.stream().filter( str -> str.startsWith("A")).map(String::toUpperCase).toList();
        System.out.println(resultName);

        result=names.stream().filter( str -> str.contains("it")).findFirst();
        System.out.println(result.orElse("Not Found"));

        nums = Arrays.asList(1,2,3,4,5,6,7,8,9,10);

        Set<Integer> set= new HashSet<>(nums);
        System.out.println(set);

        String str=nums.stream().map(String::valueOf).collect(Collectors.joining(","));
        System.out.println(str);

        Map<Boolean,List<Integer>> map=nums.stream().collect(Collectors.partitioningBy( a -> a%2==0));
        System.out.println(map);

        map=nums.stream().collect(Collectors.partitioningBy( a -> a<5));
        System.out.println(map);

        List<Employee> employees = Arrays.asList(
                new Employee("A", "IT", 70000),
                new Employee("B", "HR", 50000),
                new Employee("C", "IT", 90000),
                new Employee("D", "HR", 60000),
                new Employee("E", "Finance", 80000),
                new Employee("F", "IT", 75000)
        );
        Map<String,List<String>> map2=employees
                .stream().
                collect(
                        Collectors.groupingBy(Employee::getDepartment,
                                Collectors.mapping(Employee::getName,Collectors.toList())
                        )
                );
        System.out.println(map2);

        Map<String,Long> countMap=
                employees.stream().collect(Collectors.groupingBy(Employee::getDepartment,Collectors.counting()));
        System.out.println(countMap );

        Map<String,Double> averageMap=
                employees.stream().collect(Collectors.groupingBy(Employee::getDepartment,Collectors.averagingInt(Employee::getSalary)));
        System.out.println(averageMap );

        Map<String,Optional<Employee>> highestPaidEmployee=
                employees.stream().collect(Collectors.groupingBy(Employee::getDepartment,Collectors.maxBy(Comparator.comparing(Employee::getSalary))));
        System.out.println(highestPaidEmployee );


        List<Employee> emps = Arrays.asList(
                new Employee("Aniket", "IT", 90000,
                        Arrays.asList("Java", "Spring", "Kafka")),

                new Employee("Rahul", "IT", 70000,
                        Arrays.asList("Java", "AWS")),

                new Employee("Aman", "HR", 60000,
                        Arrays.asList("Excel", "Recruitment")),

                new Employee("Rohit", "IT", 95000,
                        Arrays.asList("Java", "Docker", "Kubernetes")),

                new Employee("Priya", "HR", 80000,
                        Arrays.asList("Recruitment", "Excel"))
        );
        System.out.println();
        System.out.println("===================================================================Final Challenge===============================================================================");
        System.out.println();

        //        Find all IT employees earning > ₹75,000.
        List<Employee> emp=emps.stream().filter(a -> "IT".equals(a.getDepartment()) && a.getSalary()>75000).collect(Collectors.toList());
        System.out.println(emp);

//        Find the highest-paid employee.
        Employee highestPaidEmp= emps.stream().max(Comparator.comparing(Employee::getSalary)).orElse(null);
        System.out.println(highestPaidEmp);
//
//        Find the highest-paid employee in every department.
        highestPaidEmployee=emps
                .stream()
                .collect(
                        Collectors.groupingBy(
                                Employee::getDepartment,
                                Collectors.maxBy(Comparator.comparing(Employee::getSalary))
                        )
                );
        System.out.println(highestPaidEmployee);
//
//        Calculate average salary per department.
        averageMap=emps
                .stream()
                .collect(
                        Collectors.groupingBy(
                                Employee::getDepartment,
                                Collectors.averagingInt(Employee::getSalary)
                        )
                );
        System.out.println(averageMap);
//
//        Find all unique skills.
        names=emps.stream().map(Employee::getSkills).flatMap(List::stream).distinct().toList();
        System.out.println(names);
//
//        Find the most common skill.
        List<String> skillsList=new ArrayList<>();
        for(Employee employee: emps){
            skillsList.addAll(employee.getSkills());
        }
        Map<String,Integer> skillFreqMap=new HashMap<>();
        int maxSkillCount=-1;
        String maxSkill="";
        for(String s:skillsList){
            skillFreqMap.put(s, skillFreqMap.getOrDefault(s,0)+1);
            if(maxSkillCount<skillFreqMap.get(s)){
                maxSkillCount=skillFreqMap.get(s);
                maxSkill=s;
            }
        }
        System.out.println("Max Skill Using Iterative Approach - "+maxSkill);


        String skill = emps
                .stream()
                .map(Employee::getSkills)
                .flatMap(List::stream)
                .collect(
                        Collectors.groupingBy(
                                Function.identity(),
                                Collectors.counting()
                        )
                )
                .entrySet()
                .stream()
                .max(Comparator.comparing(Map.Entry::getValue))
                .map(Map.Entry::getKey).orElse("Not Found")
                ;
        System.out.println("Max Skill Using Streams Approach - "+skill);
//
//
//        Find employees who know "Java".
        List<Employee> knownJava=emps.stream().filter( e -> e.getSkills().contains("Java")).toList();
        System.out.println(knownJava);
//
//        Find the department with the highest total salary.
        String department=emps
                .stream()
                .collect(
                        Collectors.groupingBy(
                                Employee::getDepartment,
                                Collectors.summingInt(Employee::getSalary)
                        )
                )
                .entrySet()
                .stream()
                .max(Comparator.comparing(Map.Entry::getValue))
                .map(Map.Entry::getKey).orElse("Not Found");
        System.out.println(department);
//        Create:
//
//        Map<String, List<String>>
//
//        where:
//
//        department → employee names
//
        Map<String, List<String>> res=emps
                .stream()
                .collect(
                        Collectors.groupingBy(
                                Employee::getDepartment,
                                Collectors.mapping(Employee::getName,Collectors.toList())
                        )
                );
        System.out.println(res);
//
//        Create:
//
//        Map<String, Long>
//
//        where:
//
//        skill → number of employees having that skill
//
//        Find the second-highest-paid employee.
        Employee secondHighestPaidEmployee=emps
                .stream()
                .sorted(Comparator.comparing(Employee::getSalary))
                .skip(emps.size()-2)
                .findFirst()
                .orElse(null);
        System.out.println(secondHighestPaidEmployee);
//
//        Find the second-highest salary in each department.
        Map<String, Employee> resultNew=emps
                .stream()
                .collect(
                        Collectors.groupingBy(
                                Employee::getDepartment,
                                Collectors.collectingAndThen(
                                        Collectors.toList(),
                                        lis -> lis.stream().sorted(Comparator.comparing(Employee::getSalary).reversed()).skip(1).findFirst().orElse(null)
                                )
                        )
                );

        System.out.println(resultNew);

        Stack<Character> st=new Stack<>();
        st.push('1');
        st.push('2');
        st.push('3');
        st.push('5');
        String s=st.stream().map(String::valueOf).collect(Collectors.joining());
        System.out.println(s);
    }
}
