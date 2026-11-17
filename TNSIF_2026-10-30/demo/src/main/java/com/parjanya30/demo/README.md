fetch("http://localhost:8080/courses/1", {
  method: "DELETE"
})
  .then(response => {
    console.log("HTTP status:", response.status);

    if (response.status === 204) {
      console.log("Course with ID 1 was deleted successfully.");
    } else if (response.status === 404) {
      console.log("Course with ID 1 was not found.");
    }
  });