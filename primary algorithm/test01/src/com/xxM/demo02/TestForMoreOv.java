package com.xxM.demo01;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

class Emp {
    private String name;
    private String job;
    private double salary;
    private Date hireDate;
    private Dept dept = new Dept();

    public Emp() {
    }

    public Emp(String name, String job, double salary, Date hireDate, Dept dept) {
        this.name = name;
        this.job = job;
        this.salary = salary;
        this.hireDate = hireDate;
        this.dept = dept;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "name='" + name + '\'' +
                ", job='" + job + '\'' +
                ", salary=" + salary +
                ", hireDate=" + hireDate +
                ", dept=" + dept +
                '}';
    }
}

class Dept {
    private String name;
    private String loc;
    private Long count;
    private Company company = new Company();

    public Dept() {
    }

    public Dept(String name, String loc, Long count, Company company) {
        this.name = name;
        this.loc = loc;
        this.count = count;
        this.company = company;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    @Override
    public String toString() {
        return "Dept{" +
                "name='" + name + '\'' +
                ", loc='" + loc + '\'' +
                ", count=" + count +
                ", company=" + company +
                '}';
    }
}

class Company {
    private Integer cid;
    private String name;
    private String address;
    private Date createDate;

    public Company() {
    }

    public Company(Integer cid, String name, String address, Date createDate) {
        this.cid = cid;
        this.name = name;
        this.address = address;
        this.createDate = createDate;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        return "Company{" +
                "cid=" + cid +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", createDate=" + createDate +
                '}';
    }
}

class EmpAction {
    private Emp emp = new Emp();

    public void setValue(String val) throws NoSuchMethodException, ParseException, InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchFieldException {
        BeanOperation.setBeanValue(this, val);
    }

    public Emp getEmp() {
        return this.emp;
    }
}

class BeanOperation {
    private BeanOperation() {
    }

    public static void setBeanValue(Object actionObject, String msg) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException, NoSuchFieldException, ParseException {
        String[] result = msg.split("\\|");
        for (int i = 0; i < result.length; i++) {
            String[] temp = result[i].split(":",2);
            String attribute = temp[0];
            String[] field = attribute.split("\\.");
            if (field.length > 2) {
                Object currentObject = actionObject;
                for (int i1 = 0; i1 < field.length - 1; i1++) {
                    currentObject = ObjectUtils.getObjectValue(currentObject, field[i1]);
                    //取得上一级属性
                }
                Object value = ObjectValueUtils.getValue(currentObject, field[field.length - 1], temp[1]);
                ObjectUtils.setObjectValue(currentObject, field[field.length - 1], value);
            } else {
                Object currentObject = ObjectUtils.getObjectValue(actionObject, field[0]);
                Object value = ObjectValueUtils.getValue(currentObject, field[1], temp[1]);
                ObjectUtils.setObjectValue(currentObject, field[1], value);
            }
        }
    }
}

class ObjectValueUtils {
    private ObjectValueUtils() {
    }

    public static Object getValue(Object wrapObject, String attribute, String value) throws NoSuchFieldException, ParseException {
        Field field = ObjectUtils.getObjectField(wrapObject, attribute);
        if (field == null) {
            return null;
        }
        return stringToType(field.getType().getSimpleName(), value);
    }

    public static Object stringToType(String type, String value) throws ParseException {
        if ("String".equals(type)) {
            if (isNotEmpty(value)) {
                return value;
            } else {
                return null;
            }
        } else if ("int".equals(type) || "Integer".equals(type)) {
            if (isInt(value)) {
                return Integer.parseInt(value);
            } else {
                return null;
            }
        } else if ("double".equals(type) || "Double".equals(type)) {
            if (isDouble(value)) {
                return Double.parseDouble(value);
            } else {
                return null;
            }
        } else if ("long".equals(type) || "Long".equals(type)) {
            if (isLong(value)) {
                return Long.parseLong(value);
            } else {
                return null;
            }
        } else if ("Date".equals(type)) {
            if (isDate(value)) {
                return new SimpleDateFormat("yyyy-MM-dd").parse(value);
            } else if (isDateTime(value)) {
                return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(value);
            } else {
                return null;
            }
        }
        return null;
    }

    public static boolean isDate(String value) {
        if (isNotEmpty(value)) {
            return value.matches("\\d{4}-\\d{1,2}-\\d{1,2}");
        }
        return false;
    }

    public static boolean isDateTime(String value) {
        if (isNotEmpty(value)) {
            return value.matches("\\d{4}-\\d{1,2}-\\d{1,2} \\d{1,2}:\\d{1,2}:\\d{1,2}");
        }
        return false;
    }

    public static boolean isLong(String value) {
        if (isNotEmpty(value)) {
            return value.matches("\\d+");
        }
        return false;
    }

    public static boolean isDouble(String value) {
        if (isNotEmpty(value)) {
            return value.matches("\\d+(\\.\\d+)?");
        }
        return false;
    }

    public static boolean isInt(String value) {
        if (isNotEmpty(value)) {
            return value.matches("\\d+");
        } else {
            return false;
        }
    }

    private static boolean isNotEmpty(String str) {
        return !(str == null || str.isEmpty() || "".equals(str));
    }
}

class ObjectUtils {
    private ObjectUtils() {
    }

    public static Field getObjectField(Object wrapObject, String attribute) throws NoSuchFieldException {
        Field field = wrapObject.getClass().getDeclaredField(attribute);
        if (field == null) {
            field = wrapObject.getClass().getField(attribute);
        }
        return field;
    }

    public static void setObjectValue(Object wrapObject, String attribute, Object value) throws NoSuchFieldException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Field field = getObjectField(wrapObject, attribute);
        if (field == null) {
            return;
        }
        String methodName = "set" + StringUtils.initcap(attribute);
        Method method = wrapObject.getClass().getMethod(methodName, field.getType());
        method.invoke(wrapObject, value);
    }

    public static Object getObjectValue(Object wrapObject, String attribute) throws NoSuchFieldException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
        Field field = getObjectField(wrapObject, attribute);
        if (field == null) {
            return null;
        }
        String methodName = "get" + StringUtils.initcap(attribute);
        Method method = wrapObject.getClass().getMethod(methodName);
        Object obj = method.invoke(wrapObject);
        if (obj == null) {
            obj = field.getType().newInstance();
            setObjectValue(wrapObject, attribute, obj);
        }
        return obj;
    }
}

class StringUtils {
    private StringUtils() {
    }

    public static String initcap(String str) {
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }
}

/**
 * @Author Mr Liu
 */
public class TestForMoreOv {
    public static void main(String[] args) throws NoSuchMethodException, ParseException, InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchFieldException {
        String value = "emp.name:张飞|emp.job:技术总监|emp.salary:89880.31|emp.hireDate:1991-11-22|" +
                "emp.dept.name:技术部|emp.dept.loc:北京|emp.dept.count:84930|" +
                "emp.dept.company.cid:77001|" + "emp.dept.company.name:阿里巴巴|" +
                "emp.dept.company.address:杭州|emp.dept.company.createDate:1870-1-1 11:1:1";
//        String value = "emp.name:SMITH|emp.job:CLERK|emp.dept.name:技术部|emp.dept.loc:故宫" +
//                "|emp.dept.company.name:MLDN|emp.dept.company.address:北京|" +
//                "emp.salary:1999.13|emp.hireDate:1990-10-10|" +
//                "emp.dept.count:41341514532|" +
//                "emp.dept.company.cid:12121|" +
//                "emp.dept.company.createDate:1990-09-15 10:10:10";
        EmpAction empAction = new EmpAction();
        empAction.setValue(value);
        System.out.println(empAction.getEmp());
    }
}
