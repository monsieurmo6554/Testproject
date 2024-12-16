document.addEventListener("DOMContentLoaded", () => {
    const form = document.getElementById("task-form");
    const taskList = document.querySelector("ul");

    form.addEventListener("submit", (e) => {
        e.preventDefault();
        const taskInput = form.querySelector("input[name='task']");
        if (taskInput.value.trim()) {
            const li = document.createElement("li");
            li.textContent = taskInput.value;
            taskList.appendChild(li);
            taskInput.value = ""; // Clear input
        }
    });
});
