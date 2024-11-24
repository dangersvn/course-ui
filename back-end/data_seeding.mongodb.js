/* global use, db */
// MongoDB Playground
// Use Ctrl+Space inside a snippet or a string literal to trigger completions.

const database = 'learning_platform';
const collection = 'courses';

// Create a new database.
use(database);

// Create a new collection.
db.createCollection(collection);
db.courses.insertMany([
    {
      title: "Angular Fundamentals",
      slug: "angular-fundamentals",
      description: "Master Angular framework from scratch. Learn components, services, routing, and more with hands-on projects.",
      thumbnail: "/assets/courses/angular-fundamentals.jpg",
      level: "Beginner",
      duration: 24, // hours
      price: 49.99,
      tags: ["Angular", "TypeScript", "Frontend", "Web Development"],
      category: "Frontend Development",
      prerequisites: ["Basic JavaScript", "HTML & CSS"],
      status: "Published",
      publishedAt: new Date("2024-03-15"),
      instructorId: ObjectId("507f1f77bcf86cd799439011"), // Replace with actual instructor ID
      ratings: {
        average: 4.5,
        count: 128
      },
      enrollmentCount: 256,
      sections: [
        {
          title: "Getting Started with Angular",
          description: "Introduction to Angular framework and setup",
          order: 1,
          subsections: [
            {
              title: "What is Angular?",
              description: "Introduction to Angular framework and its benefits",
              order: 1,
              contentType: "Text",
              content: "<h1>Introduction to Angular</h1><p>Angular is a platform and framework for building client applications...</p>",
              duration: 15,
              isPreview: true
            },
            {
              title: "Setting Up Development Environment",
              description: "Installing Node.js, npm, and Angular CLI",
              order: 2,
              contentType: "Text",
              content: "<h1>Development Environment Setup</h1><p>Let's set up everything you need...</p>",
              duration: 20,
              isPreview: false
            }
          ]
        }
      ]
    },
    {
      title: "React for Beginners",
      slug: "react-beginners",
      description: "Complete guide to React.js. Build modern user interfaces with hooks, context, and Redux.",
      thumbnail: "/assets/courses/react-beginners.jpg",
      level: "Beginner",
      duration: 20,
      price: 45.99,
      tags: ["React", "JavaScript", "Frontend", "Web Development"],
      category: "Frontend Development",
      prerequisites: ["JavaScript Basics"],
      status: "Published",
      publishedAt: new Date("2024-03-10"),
      instructorId: ObjectId("507f1f77bcf86cd799439012"),
      ratings: {
        average: 4.7,
        count: 156
      },
      enrollmentCount: 312,
      sections: [
        {
          title: "React Fundamentals",
          description: "Core concepts of React",
          order: 1,
          subsections: [
            {
              title: "Introduction to React",
              description: "What is React and why use it",
              order: 1,
              contentType: "Text",
              content: "<h1>Welcome to React</h1><p>React is a JavaScript library for building user interfaces...</p>",
              duration: 15,
              isPreview: true
            }
          ]
        }
      ]
    },
    {
      title: "Node.js API Development",
      slug: "nodejs-api-development",
      description: "Build scalable REST APIs with Node.js, Express, and MongoDB.",
      thumbnail: "/assets/courses/nodejs-api.jpg",
      level: "Intermediate",
      duration: 18,
      price: 59.99,
      tags: ["Node.js", "Express", "MongoDB", "Backend", "API"],
      category: "Backend Development",
      prerequisites: ["JavaScript", "Basic HTTP knowledge"],
      status: "Published",
      publishedAt: new Date("2024-03-01"),
      instructorId: ObjectId("507f1f77bcf86cd799439013"),
      ratings: {
        average: 4.6,
        count: 98
      },
      enrollmentCount: 189,
      sections: [
        {
          title: "REST API Basics",
          description: "Understanding REST principles",
          order: 1,
          subsections: [
            {
              title: "What is REST?",
              description: "Introduction to REST architecture",
              order: 1,
              contentType: "Text",
              content: "<h1>REST Architecture</h1><p>REST is an architectural style for distributed systems...</p>",
              duration: 20,
              isPreview: true
            }
          ]
        }
      ]
    },
    {
      title: "Python Data Science",
      slug: "python-data-science",
      description: "Learn data analysis, visualization, and machine learning with Python.",
      thumbnail: "/assets/courses/python-data-science.jpg",
      level: "Advanced",
      duration: 30,
      price: 79.99,
      tags: ["Python", "Data Science", "Machine Learning", "Pandas", "NumPy"],
      category: "Data Science",
      prerequisites: ["Python Basics", "Mathematics"],
      status: "Published",
      publishedAt: new Date("2024-02-15"),
      instructorId: ObjectId("507f1f77bcf86cd799439014"),
      ratings: {
        average: 4.8,
        count: 76
      },
      enrollmentCount: 145,
      sections: [
        {
          title: "Data Analysis with Pandas",
          description: "Working with data using Pandas",
          order: 1,
          subsections: [
            {
              title: "Introduction to Pandas",
              description: "Basic operations with Pandas",
              order: 1,
              contentType: "Text",
              content: "<h1>Pandas Basics</h1><p>Pandas is a powerful data manipulation library...</p>",
              duration: 25,
              isPreview: true
            }
          ]
        }
      ]
    }
  ]);
  
// The prototype form to create a collection:
/* db.createCollection( <name>,
  {
    capped: <boolean>,
    autoIndexId: <boolean>,
    size: <number>,
    max: <number>,
    storageEngine: <document>,
    validator: <document>,
    validationLevel: <string>,
    validationAction: <string>,
    indexOptionDefaults: <document>,
    viewOn: <string>,
    pipeline: <pipeline>,
    collation: <document>,
    writeConcern: <document>,
    timeseries: { // Added in MongoDB 5.0
      timeField: <string>, // required for time series collections
      metaField: <string>,
      granularity: <string>,
      bucketMaxSpanSeconds: <number>, // Added in MongoDB 6.3
      bucketRoundingSeconds: <number>, // Added in MongoDB 6.3
    },
    expireAfterSeconds: <number>,
    clusteredIndex: <document>, // Added in MongoDB 5.3
  }
)*/

// More information on the `createCollection` command can be found at:
// https://www.mongodb.com/docs/manual/reference/method/db.createCollection/
