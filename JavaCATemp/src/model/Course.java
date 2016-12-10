package model;

import java.io.*;
import java.sql.Date;

 
public class Course implements Cloneable, Serializable {

    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String courseId;
    private String courseName;
    private java.sql.Date courseStart;
    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + courseCredit;
		result = prime * result + ((courseDesc == null) ? 0 : courseDesc.hashCode());
		result = prime * result + ((courseEnd == null) ? 0 : courseEnd.hashCode());
		result = prime * result + ((courseId == null) ? 0 : courseId.hashCode());
		result = prime * result + courseMaxSize;
		result = prime * result + ((courseName == null) ? 0 : courseName.hashCode());
		result = prime * result + ((courseStart == null) ? 0 : courseStart.hashCode());
		result = prime * result + enrolled;
		result = prime * result + ((lectureId == null) ? 0 : lectureId.hashCode());
		result = prime * result + ((studentEmail == null) ? 0 : studentEmail.hashCode());
		result = prime * result + ((studentGrade == null) ? 0 : studentGrade.hashCode());
		result = prime * result + ((studentId == null) ? 0 : studentId.hashCode());
		result = prime * result + ((studentName == null) ? 0 : studentName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Course other = (Course) obj;
		if (courseCredit != other.courseCredit)
			return false;
		if (courseDesc == null) {
			if (other.courseDesc != null)
				return false;
		} else if (!courseDesc.equals(other.courseDesc))
			return false;
		if (courseEnd == null) {
			if (other.courseEnd != null)
				return false;
		} else if (!courseEnd.equals(other.courseEnd))
			return false;
		if (courseId == null) {
			if (other.courseId != null)
				return false;
		} else if (!courseId.equals(other.courseId))
			return false;
		if (courseMaxSize != other.courseMaxSize)
			return false;
		if (courseName == null) {
			if (other.courseName != null)
				return false;
		} else if (!courseName.equals(other.courseName))
			return false;
		if (courseStart == null) {
			if (other.courseStart != null)
				return false;
		} else if (!courseStart.equals(other.courseStart))
			return false;
		if (enrolled != other.enrolled)
			return false;
		if (lectureId == null) {
			if (other.lectureId != null)
				return false;
		} else if (!lectureId.equals(other.lectureId))
			return false;
		if (studentEmail == null) {
			if (other.studentEmail != null)
				return false;
		} else if (!studentEmail.equals(other.studentEmail))
			return false;
		if (studentGrade == null) {
			if (other.studentGrade != null)
				return false;
		} else if (!studentGrade.equals(other.studentGrade))
			return false;
		if (studentId == null) {
			if (other.studentId != null)
				return false;
		} else if (!studentId.equals(other.studentId))
			return false;
		if (studentName == null) {
			if (other.studentName != null)
				return false;
		} else if (!studentName.equals(other.studentName))
			return false;
		return true;
	}

	private java.sql.Date courseEnd;
    private int courseCredit;
    private int courseMaxSize;
    private String courseDesc;
    private String lectureId;
    private int enrolled;
    private String studentName;
    private String studentEmail;
    private String studentId;
    private String studentGrade;

    /** 
     * Constructors. DaoGen generates two constructors by default.
     * The first one takes no arguments and provides the most simple
     * way to create object instance. The another one takes one
     * argument, which is the primary key of the corresponding table.
     */

    public Course () {

    }

    public Course (String courseIdIn) {

          this.courseId = courseIdIn;

    }
    public Course(String courseId, String courseName, Date courseStart, Date courseEnd, double courseCredit,
			int courseMaxSize, String courseDesc, String lectureId) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.courseStart = courseStart;
		this.courseEnd = courseEnd;
		this.courseCredit = (int) courseCredit;
		this.courseMaxSize = courseMaxSize;
		this.courseDesc = courseDesc;
		this.lectureId = lectureId;
	}

    public String getCourseId() {
          return this.courseId;
    }
    public void setCourseId(String courseIdIn) {
          this.courseId = courseIdIn;
    }

    public String getCourseName() {
          return this.courseName;
    }
    public void setCourseName(String courseNameIn) {
          this.courseName = courseNameIn;
    }

    public java.sql.Date getCourseStart() {
          return this.courseStart;
    }
    public void setCourseStart(java.sql.Date courseStartIn) {
          this.courseStart = courseStartIn;
    }

    public java.sql.Date getCourseEnd() {
          return this.courseEnd;
    }
    public void setCourseEnd(java.sql.Date courseEndIn) {
          this.courseEnd = courseEndIn;
    }

    public int getCourseCredit() {
          return this.courseCredit;
    }
    public void setCourseCredit(int courseCreditIn) {
          this.courseCredit = courseCreditIn;
    }

    public int getCourseMaxSize() {
          return this.courseMaxSize;
    }
    public void setCourseMaxSize(int courseMaxSizeIn) {
          this.courseMaxSize = courseMaxSizeIn;
    }

    public String getCourseDesc() {
          return this.courseDesc;
    }
    public void setCourseDesc(String courseDescIn) {
          this.courseDesc = courseDescIn;
    }

    public String getLectureId() {
          return this.lectureId;
    }
    public void setLectureId(String lectureIdIn) {
          this.lectureId = lectureIdIn;
    }

    public int getEnrolled() {
		return enrolled;
	}

	public void setEnrolled(int enrolled) {
		this.enrolled = enrolled;
	}  

   
    
    /**
     * toString will return String object representing the state of this 
     * valueObject. This is useful during application development, and 
     * possibly when application is writing object states in textlog.
     */
    public String toString() {
        StringBuffer out = new StringBuffer();
        out.append("\nclass Course, mapping to table courses\n");
        out.append("Persistent attributes: \n"); 
        out.append("courseId = " + this.courseId + "\n"); 
        out.append("courseName = " + this.courseName + "\n"); 
        out.append("courseStart = " + this.courseStart + "\n"); 
        out.append("courseEnd = " + this.courseEnd + "\n"); 
        out.append("courseCredit = " + this.courseCredit + "\n"); 
        out.append("courseMaxSize = " + this.courseMaxSize + "\n"); 
        out.append("courseDesc = " + this.courseDesc + "\n"); 
        out.append("lectureId = " + this.lectureId + "\n"); 
        out.append("enrolled = " + this.enrolled + "\n"); 
        out.append("studentId = " + this.studentId + "\n"); 
        out.append("studentEmail = " + this.studentEmail + "\n"); 
        out.append("studentName = " + this.studentName + "\n"); 
        out.append("studentGrade = " + this.studentGrade + "\n"); 
        return out.toString();
    }


    /**
     * Clone will return identical deep copy of this valueObject.
     * Note, that this method is different than the clone() which
     * is defined in java.lang.Object. Here, the retuned cloned object
     * will also have all its attributes cloned.
     */
    public Object clone() {
        Course cloned = new Course();

        if (this.courseId != null)
             cloned.setCourseId(new String(this.courseId)); 
        if (this.courseName != null)
             cloned.setCourseName(new String(this.courseName)); 
        if (this.courseStart != null)
             cloned.setCourseStart((java.sql.Date)this.courseStart.clone()); 
        if (this.courseEnd != null)
             cloned.setCourseEnd((java.sql.Date)this.courseEnd.clone()); 
        cloned.setCourseCredit(this.courseCredit); 
        cloned.setCourseMaxSize(this.courseMaxSize); 
        if (this.courseDesc != null)
             cloned.setCourseDesc(new String(this.courseDesc)); 
        if (this.lectureId != null)
             cloned.setLectureId(new String(this.lectureId));
        if (this.studentId != null)
            cloned.setStudentId(new String(this.studentEmail));
        if (this.studentEmail != null)
            cloned.setStudentEmail(new String(this.studentEmail));
        if (this.studentName != null)
            cloned.setStudentName(new String(this.studentName));
        if (this.studentGrade != null)
            cloned.setStudentName(new String(this.studentGrade));
        cloned.setEnrolled(this.enrolled);
        return cloned;
    }

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getStudentEmail() {
		return studentEmail;
	}

	public void setStudentEmail(String studentEmail) {
		this.studentEmail = studentEmail;
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getStudentGrade() {
		return studentGrade;
	}

	public void setStudentGrade(String studentGrade) {
		this.studentGrade = studentGrade;
	}

	 

}