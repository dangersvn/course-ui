----------------- Schema ---------------
I'll help you design the MongoDB schema for the course management system. I'll break it down into different collections and their relationships.

1. Course Collection:
```javascript
{
  _id: ObjectId,
  title: String,
  slug: String,  // URL-friendly version of title
  description: String,
  thumbnail: String,  // URL to course thumbnail
  level: String,  // (Beginner, Intermediate, Advanced)
  duration: Number,  // Total duration in hours
  price: Number,
  tags: [String],
  category: String,
  prerequisites: [String],
  status: String,  // (Draft, Published, Archived)
  publishedAt: Date,
  createdAt: Date,
  updatedAt: Date,
  instructorId: ObjectId,  // Reference to User collection
  ratings: {
    average: Number,
    count: Number
  },
  enrollmentCount: Number,
  sections: [
    {
      _id: ObjectId,
      title: String,
      description: String,
      order: Number,
      subsections: [
        {
          _id: ObjectId,
          title: String,
          description: String,
          order: Number,
          contentType: String,  // (Text, Video, Quiz, etc.)
          content: String,  // Rich text content (stored as HTML/Delta format for Quill)
          duration: Number,  // Time to complete in minutes
          isPreview: Boolean // If this content is available for preview
        }
      ]
    }
  ]
}
```

2. User Collection:
```javascript
{
  _id: ObjectId,
  email: String,
  password: String,  // Hashed
  firstName: String,
  lastName: String,
  role: String,  // (admin, instructor, student)
  avatar: String,
  bio: String,
  createdAt: Date,
  updatedAt: Date,
  lastLogin: Date,
  isActive: Boolean,
  settings: {
    notifications: Boolean,
    emailPreferences: Object
  }
}
```

3. Enrollment Collection:
```javascript
{
  _id: ObjectId,
  userId: ObjectId,
  courseId: ObjectId,
  enrolledAt: Date,
  status: String,  // (active, completed, suspended)
  completedAt: Date,
  progress: {
    overallProgress: Number,  // Percentage
    lastAccessedAt: Date,
    lastAccessedSection: ObjectId,
    lastAccessedSubsection: ObjectId,
    completedSubsections: [
      {
        subsectionId: ObjectId,
        completedAt: Date
      }
    ]
  },
  notes: [
    {
      subsectionId: ObjectId,
      content: String,
      createdAt: Date
    }
  ],
  bookmarks: [ObjectId]  // Array of subsection IDs
}
```

4. Questions Collection (for Q&A tab):
```javascript
{
  _id: ObjectId,
  courseId: ObjectId,
  sectionId: ObjectId,
  subsectionId: ObjectId,
  userId: ObjectId,  // Who asked the question
  title: String,
  content: String,
  createdAt: Date,
  updatedAt: Date,
  status: String,  // (open, answered, closed)
  votes: Number,
  answers: [
    {
      userId: ObjectId,
      content: String,
      createdAt: Date,
      updatedAt: Date,
      isAccepted: Boolean,
      votes: Number
    }
  ],
  tags: [String]
}
```

5. Assessment Collection:
```javascript
{
  _id: ObjectId,
  courseId: ObjectId,
  sectionId: ObjectId,
  subsectionId: ObjectId,
  title: String,
  description: String,
  type: String,  // (quiz, assignment, project)
  timeLimit: Number,  // in minutes
  passingScore: Number,
  questions: [
    {
      _id: ObjectId,
      type: String,  // (multiple-choice, coding, essay)
      question: String,
      options: [String],  // For multiple choice
      correctAnswer: Mixed,
      points: Number
    }
  ],
  createdAt: Date,
  updatedAt: Date
}
```

6. Assessment Results Collection:
```javascript
{
  _id: ObjectId,
  userId: ObjectId,
  assessmentId: ObjectId,
  startedAt: Date,
  completedAt: Date,
  score: Number,
  answers: [
    {
      questionId: ObjectId,
      answer: Mixed,
      isCorrect: Boolean,
      points: Number
    }
  ],
  feedback: String
}
```

Sample Course Document:
```javascript
{
  _id: ObjectId("..."),
  title: "Angular Fundamentals",
  slug: "angular-fundamentals",
  description: "Complete guide to Angular development",
  thumbnail: "https://example.com/angular-course.jpg",
  level: "Beginner",
  duration: 20,
  price: 49.99,
  tags: ["Angular", "TypeScript", "Web Development"],
  category: "Frontend Development",
  prerequisites: ["Basic JavaScript", "HTML & CSS"],
  status: "Published",
  publishedAt: ISODate("2024-03-15"),
  instructorId: ObjectId("..."),
  ratings: {
    average: 4.5,
    count: 128
  },
  enrollmentCount: 256,
  sections: [
    {
      _id: ObjectId("..."),
      title: "Getting Started",
      description: "Introduction to Angular",
      order: 1,
      subsections: [
        {
          _id: ObjectId("..."),
          title: "What is Angular?",
          description: "Introduction to Angular framework",
          order: 1,
          contentType: "Text",
          content: "<h1>Introduction to Angular</h1><p>Angular is a platform...</p>",
          duration: 15,
          isPreview: true
        }
      ]
    }
  ]
}
```

Key Design Considerations:

1. Scalability:
   - Embedded subsections within sections for faster retrieval
   - Separate collections for dynamic data (enrollments, questions, assessments)
   - Indexed fields for frequent queries (status, tags, category)

2. Performance:
   - Denormalized data where appropriate (e.g., course ratings)
   - Separate collection for assessment results
   - Progress tracking at subsection level

3. Flexibility:
   - Support for different content types
   - Extensible assessment system
   - Configurable course settings

4. Query Patterns:
   - Easy filtering by status, category, tags
   - Quick access to user progress
   - Efficient course content retrieval

Would you like me to explain any specific part of the schema or provide example queries for common operations?

----------------- APIs ----------------
Yes, let me show you how this schema supports course discovery and enrollment, along with some example queries and potential API endpoints.

1. Course Search/Discovery Functionality:

```javascript
// Example MongoDB queries for course search/discovery

// Search courses by title, description, or tags
db.courses.find({
  status: "Published",
  $or: [
    { title: { $regex: searchTerm, $options: 'i' } },
    { description: { $regex: searchTerm, $options: 'i' } },
    { tags: { $in: [searchTerm] } }
  ]
})

// Filter courses by category and level
db.courses.find({
  status: "Published",
  category: selectedCategory,
  level: selectedLevel
})

// Get popular courses based on enrollment count
db.courses.find({
  status: "Published"
}).sort({ enrollmentCount: -1 }).limit(10)

// Get highly rated courses
db.courses.find({
  status: "Published",
  "ratings.count": { $gt: 10 }  // Minimum ratings threshold
}).sort({ "ratings.average": -1 })
```

2. Course Enrollment Process:

```javascript
// Check if user is already enrolled
db.enrollments.findOne({
  userId: currentUserId,
  courseId: selectedCourseId
})

// Create new enrollment
db.enrollments.insertOne({
  userId: currentUserId,
  courseId: selectedCourseId,
  enrolledAt: new Date(),
  status: "active",
  progress: {
    overallProgress: 0,
    lastAccessedAt: new Date(),
    completedSubsections: []
  }
})

// Update course enrollment count
db.courses.updateOne(
  { _id: selectedCourseId },
  { $inc: { enrollmentCount: 1 } }
)
```

Let me break down the key functionality supported by this schema:

1. Course Discovery Features:
   ```typescript
   interface CourseSearchFilters {
     searchTerm?: string;
     category?: string;
     level?: string;
     priceRange?: {
       min: number;
       max: number;
     };
     duration?: string;
     rating?: number;
     tags?: string[];
   }

   // Example API Endpoints
   GET /api/courses?search=angular&category=frontend&level=beginner
   GET /api/courses/popular
   GET /api/courses/featured
   GET /api/courses/new-releases
   ```

2. Course Details:
   ```typescript
   // Example API Endpoints
   GET /api/courses/:courseId
   GET /api/courses/:courseId/syllabus
   GET /api/courses/:courseId/reviews
   ```

3. Enrollment Process:
   ```typescript
   // Example API Endpoints
   POST /api/enrollments
   {
     courseId: string;
     userId: string;
   }

   // Get user's enrolled courses
   GET /api/users/:userId/enrollments
   ```

4. Progress Tracking:
   ```typescript
   // Example API Endpoints
   GET /api/enrollments/:enrollmentId/progress
   PATCH /api/enrollments/:enrollmentId/progress
   {
     subsectionId: string;
     completed: boolean;
   }
   ```

Recommended Indexes for Performance:

```javascript
// Indexes for course search and filtering
db.courses.createIndex({ status: 1 });
db.courses.createIndex({ title: "text", description: "text" });
db.courses.createIndex({ category: 1, status: 1 });
db.courses.createIndex({ tags: 1, status: 1 });
db.courses.createIndex({ "ratings.average": 1, status: 1 });
db.courses.createIndex({ enrollmentCount: 1, status: 1 });

// Indexes for enrollments
db.enrollments.createIndex({ userId: 1, courseId: 1 }, { unique: true });
db.enrollments.createIndex({ userId: 1, status: 1 });
```

Business Rules to Implement:

1. Enrollment Validation:
   - Check if course is published
   - Verify user hasn't already enrolled
   - Validate any prerequisites
   - Handle payment if course is paid

2. Progress Tracking:
   - Calculate overall progress based on completed subsections
   - Track last accessed position
   - Record completion timestamps

3. Search Optimization:
   - Implement text search for course title and description
   - Support filtering by multiple criteria
   - Sort by relevance, rating, or popularity

4. Access Control:
   - Only show published courses in search
   - Restrict access to enrolled courses
   - Handle preview content differently

Example Angular Service:

```typescript
@Injectable({
  providedIn: 'root'
})
export class CourseService {
  constructor(private http: HttpClient) {}

  searchCourses(filters: CourseSearchFilters): Observable<Course[]> {
    return this.http.get<Course[]>('/api/courses', {
      params: this.buildSearchParams(filters)
    });
  }

  enrollInCourse(courseId: string): Observable<Enrollment> {
    return this.http.post<Enrollment>('/api/enrollments', {
      courseId,
      userId: this.getCurrentUserId()
    });
  }

  getEnrolledCourses(): Observable<(Course & Enrollment)[]> {
    return this.http.get<(Course & Enrollment)[]>('/api/users/me/enrollments');
  }

  getCourseProgress(enrollmentId: string): Observable<EnrollmentProgress> {
    return this.http.get<EnrollmentProgress>(
      `/api/enrollments/${enrollmentId}/progress`
    );
  }
}
```

Would you like me to provide more details about implementing any of these features or explain other aspects of the schema?
