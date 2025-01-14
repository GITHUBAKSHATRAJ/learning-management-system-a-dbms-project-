const canvas = document.getElementById('squaresCanvas');
const ctx = canvas.getContext('2d');

const squareSize = 50;
const hoverFillColor = '#222';
const borderColor = '#999';
const direction = 'right';
const speed = 1;

let gridOffset = { x: 0, y: 0 };
let hoveredSquare = null;
let numSquaresX, numSquaresY;

const resizeCanvas = () => {
  canvas.width = window.innerWidth;
  canvas.height = window.innerHeight;
  numSquaresX = Math.ceil(canvas.width / squareSize) + 1;
  numSquaresY = Math.ceil(canvas.height / squareSize) + 1;
};

const drawGrid = () => {
  ctx.clearRect(0, 0, canvas.width, canvas.height);

  for (let x = 0; x < numSquaresX; x++) {
    for (let y = 0; y < numSquaresY; y++) {
      const squareX = x * squareSize + (gridOffset.x % squareSize);
      const squareY = y * squareSize + (gridOffset.y % squareSize);

      if (hoveredSquare && hoveredSquare.x === x && hoveredSquare.y === y) {
        ctx.fillStyle = hoverFillColor;
        ctx.fillRect(squareX, squareY, squareSize, squareSize);
      }

      ctx.strokeStyle = borderColor;
      ctx.strokeRect(squareX, squareY, squareSize, squareSize);
    }
  }

  const gradient = ctx.createRadialGradient(
    canvas.width / 2,
    canvas.height / 2,
    0,
    canvas.width / 2,
    canvas.height / 2,
    Math.sqrt(canvas.width ** 2 + canvas.height ** 2) / 2
  );
  gradient.addColorStop(0, 'rgba(0, 0, 0, 0)');
  gradient.addColorStop(1, '#000');

  ctx.fillStyle = gradient;
  ctx.fillRect(0, 0, canvas.width, canvas.height);
};

const updateAnimation = () => {
  switch (direction) {
    case 'right':
      gridOffset.x -= speed;
      break;
    case 'left':
      gridOffset.x += speed;
      break;
    case 'down':
      gridOffset.y += speed;
      break;
    case 'up':
      gridOffset.y -= speed;
      break;
    case 'diagonal':
      gridOffset.x -= speed;
      gridOffset.y -= speed;
      break;
    default:
      break;
  }

  if (Math.abs(gridOffset.x) > squareSize) gridOffset.x = 0;
  if (Math.abs(gridOffset.y) > squareSize) gridOffset.y = 0;

  drawGrid();
  requestAnimationFrame(updateAnimation);
};

const handleMouseMove = (event) => {
  const rect = canvas.getBoundingClientRect();
  const mouseX = event.clientX - rect.left;
  const mouseY = event.clientY - rect.top;

  const hoveredSquareX = Math.floor(
    (mouseX - (gridOffset.x % squareSize)) / squareSize
  );
  const hoveredSquareY = Math.floor(
    (mouseY - (gridOffset.y % squareSize)) / squareSize
  );

  hoveredSquare = { x: hoveredSquareX, y: hoveredSquareY };
};

const handleMouseLeave = () => {
  hoveredSquare = null;
};

window.addEventListener('resize', resizeCanvas);
canvas.addEventListener('mousemove', handleMouseMove);
canvas.addEventListener('mouseleave', handleMouseLeave);

resizeCanvas();
requestAnimationFrame(updateAnimation);

// Canvas animation logic remains unchanged


// Event for Admin Login Button
document.getElementById('adminLogin').addEventListener('click', () => {
    window.location.href = 'Admin-login.jsp';
     // Redirect to Admin-login.jsp
  });
  
  // Event for User Login Button
  document.getElementById('userLogin').addEventListener('click', () => {
    window.location.href = 'User-login.jsp'; 
    
    // Redirect to user login logic if needed
  });
  
