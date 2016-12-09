package model;

import java.io.*;
import java.sql.*;
import java.util.*;
import java.math.*;

 /**
  * Enrollment Value Object.
  * This class is value object representing database table enrollments
  * This class is intented to be used together with associated Dao object.
  */

 /**
  * This sourcecode has been generated by FREE DaoGen generator version 2.4.1.
  * The usage of generated code is restricted to OpenSource software projects
  * only. DaoGen is available in http://titaniclinux.net/daogen/
  * It has been programmed by Tuomo Lukka, Tuomo.Lukka@iki.fi
  *
  * DaoGen license: The following DaoGen generated source code is licensed
  * under the terms of GNU GPL license. The full text for license is available
  * in GNU project's pages: http://www.gnu.org/copyleft/gpl.html
  *
  * If you wish to use the DaoGen generator to produce code for closed-source
  * commercial applications, you must pay the lisence fee. The price is
  * 5 USD or 5 Eur for each database table, you are generating code for.
  * (That includes unlimited amount of iterations with all supported languages
  * for each database table you are paying for.) Send mail to
  * "Tuomo.Lukka@iki.fi" for more information. Thank you!
  */



public class Enrollment implements Cloneable, Serializable {

    /** 
     * Persistent Instance variables. This data is directly 
     * mapped to the columns of database table.
     */
    private int enrollmentId;
    private String studentId;
    private String courseId;
    private String courseGrade;



    /** 
     * Constructors. DaoGen generates two constructors by default.
     * The first one takes no arguments and provides the most simple
     * way to create object instance. The another one takes one
     * argument, which is the primary key of the corresponding table.
     */

    public Enrollment () {

    }

    public Enrollment (int enrollmentIdIn) {

          this.enrollmentId = enrollmentIdIn;

    }
    
    public Enrollment(int enrollmentID, String studentID, String courseID, String courseGrade) {
		super();
		this.enrollmentId = enrollmentID;
		this.studentId = studentID;
		this.courseId = courseID;
		this.courseGrade = courseGrade;
	}


    /** 
     * Get- and Set-methods for persistent variables. The default
     * behaviour does not make any checks against malformed data,
     * so these might require some manual additions.
     */

    public int getEnrollmentId() {
          return this.enrollmentId;
    }
    public void setEnrollmentId(int enrollmentIdIn) {
          this.enrollmentId = enrollmentIdIn;
    }

    public String getStudentId() {
          return this.studentId;
    }
    public void setStudentId(String studentIdIn) {
          this.studentId = studentIdIn;
    }

    public String getCourseId() {
          return this.courseId;
    }
    public void setCourseId(String courseIdIn) {
          this.courseId = courseIdIn;
    }

    public String getCourseGrade() {
          return this.courseGrade;
    }
    public void setCourseGrade(String courseGradeIn) {
          this.courseGrade = courseGradeIn;
    }



    /** 
     * setAll allows to set all persistent variables in one method call.
     * This is useful, when all data is available and it is needed to 
     * set the initial state of this object. Note that this method will
     * directly modify instance variales, without going trough the 
     * individual set-methods.
     */

    public void setAll(int enrollmentIdIn,
          String studentIdIn,
          String courseIdIn,
          String courseGradeIn) {
          this.enrollmentId = enrollmentIdIn;
          this.studentId = studentIdIn;
          this.courseId = courseIdIn;
          this.courseGrade = courseGradeIn;
    }


    /** 
     * hasEqualMapping-method will compare two Enrollment instances
     * and return true if they contain same values in all persistent instance 
     * variables. If hasEqualMapping returns true, it does not mean the objects
     * are the same instance. However it does mean that in that moment, they 
     * are mapped to the same row in database.
     */
    public boolean hasEqualMapping(Enrollment valueObject) {

          if (valueObject.getEnrollmentId() != this.enrollmentId) {
                    return(false);
          }
          if (this.studentId == null) {
                    if (valueObject.getStudentId() != null)
                           return(false);
          } else if (!this.studentId.equals(valueObject.getStudentId())) {
                    return(false);
          }
          if (this.courseId == null) {
                    if (valueObject.getCourseId() != null)
                           return(false);
          } else if (!this.courseId.equals(valueObject.getCourseId())) {
                    return(false);
          }
          if (this.courseGrade == null) {
                    if (valueObject.getCourseGrade() != null)
                           return(false);
          } else if (!this.courseGrade.equals(valueObject.getCourseGrade())) {
                    return(false);
          }

          return true;
    }



    /**
     * toString will return String object representing the state of this 
     * valueObject. This is useful during application development, and 
     * possibly when application is writing object states in textlog.
     */
    public String toString() {
        StringBuffer out = new StringBuffer(this.getDaogenVersion());
        out.append("\nclass Enrollment, mapping to table enrollments\n");
        out.append("Persistent attributes: \n"); 
        out.append("enrollmentId = " + this.enrollmentId + "\n"); 
        out.append("studentId = " + this.studentId + "\n"); 
        out.append("courseId = " + this.courseId + "\n"); 
        out.append("courseGrade = " + this.courseGrade + "\n"); 
        return out.toString();
    }


    /**
     * Clone will return identical deep copy of this valueObject.
     * Note, that this method is different than the clone() which
     * is defined in java.lang.Object. Here, the retuned cloned object
     * will also have all its attributes cloned.
     */
    public Object clone() {
        Enrollment cloned = new Enrollment();

        cloned.setEnrollmentId(this.enrollmentId); 
        if (this.studentId != null)
             cloned.setStudentId(new String(this.studentId)); 
        if (this.courseId != null)
             cloned.setCourseId(new String(this.courseId)); 
        if (this.courseGrade != null)
             cloned.setCourseGrade(new String(this.courseGrade)); 
        return cloned;
    }



    /** 
     * getDaogenVersion will return information about
     * generator which created these sources.
     */
    public String getDaogenVersion() {
        return "DaoGen version 2.4.1";
    }

}