let currentQuestionIndex = 0;
let questions = [];
let correctAnswer = 0;//variable to track the number of correct answers
let totalQuestions = 0;//this will be set dynamically based on the api response

//function to fetch questions from the api

async function fectchQuestions() {
    try{
        const response = await fetch('http://localhost:8080/api/questions');//api url
        if(!response.ok){
            throw new Error('Network response was not ok');
        }

        questions = await response.json();
        totalQuestions = questions.length;
        document.getElementById('total-questions').textContent = totalQuestions;//update the total questions int the html
        displayQuestion();
    }catch(error){
        console.error('Error fetching questions:',error);
        document.getElementById('question-text').textContent = "Failed to load Questions. please Try again";
    }
    
}

function displayQuestion(){
    if(questions.length === 0) return;

    const questionText = document.getElementById('question-text');
    const optionsContainer = document.getElementById('options-container');
    const currentQuestion = questions[currentQuestionIndex];

    //update this line to match the correct property 
    questionText.textContent = currentQuestion.questionText;
    optionsContainer.innerHTML ='';//clear previous options

    currentQuestion.options.forEach(option => {
        const button = document.createElement('button');
        button.textContent = option;
        button.className = 'option';
        button.onclick = () => checkAnswer(option);//calls the checkAnswer function on click
        optionsContainer.appendChild(button);
    });

    document.getElementById('current-question').textContent = currentQuestionIndex +1;
}

//function for checking the currect answer from option selected by the user
function checkAnswer(selectedOption){
    const currentQuestion = questions[currentQuestionIndex];

    // Update this line to match the correct property
    if(selectedOption === currentQuestion.correctAnswer){
        correctAnswer++;//increment score if the answer is correct
    }

    //Automatically move to the next question after selectiong an answer
    nextQuestion();

}

//function for selecting the next question
function nextQuestion(){
    if(currentQuestionIndex < questions.length-1){
        currentQuestionIndex++;
        displayQuestion();
    }else{
        //quiz completed save score and redirect to results page
        localStorage.setItem('quizScore', correctAnswer)//saves the score
        localStorage.setItem('totalQuestions', totalQuestions)//saves total questions
        window.location.href = 'reasult.html'//rediredt to results page
    }
}

window.onload = fectchQuestions;