import * as THREE from 'three';
import { GLTFLoader } from 'three/addons/loaders/GLTFLoader.js';
import { OrbitControls } from 'three/addons/controls/OrbitControls.js';

// --- Hero Scene ---
const heroCanvas = document.getElementById('hero-canvas');
if (heroCanvas) {
    const scene = new THREE.Scene();
    const camera = new THREE.PerspectiveCamera(75, window.innerWidth / window.innerHeight, 0.1, 1000);
    camera.position.z = 5;

    const renderer = new THREE.WebGLRenderer({ canvas: heroCanvas, alpha: true });
    renderer.setSize(window.innerWidth, window.innerHeight);

    // Lighting
    const ambientLight = new THREE.AmbientLight(0xffffff, 0.8);
    scene.add(ambientLight);
    const directionalLight = new THREE.DirectionalLight(0xffffff, 1.5);
    directionalLight.position.set(5, 10, 7.5);
    scene.add(directionalLight);

    let model;
    const loader = new GLTFLoader();
    // Placeholder - replace with an actual abstract model
    // For now, let's create a placeholder geometry
    const geometry = new THREE.TorusKnotGeometry(1.5, 0.3, 200, 22);
    const material = new THREE.MeshStandardMaterial({
        color: 0xAAAAAA,
        metalness: 0.9,
        roughness: 0.3,
        wireframe: true
    });
    model = new THREE.Mesh(geometry, material);
    scene.add(model);


    // Animation Loop
    function animateHero() {
        requestAnimationFrame(animateHero);
        if (model) {
            model.rotation.x += 0.001;
            model.rotation.y += 0.002;
        }
        renderer.render(scene, camera);
    }
    animateHero();

    // Scroll Animation
    window.addEventListener('scroll', () => {
        if (model) {
            const scrollY = window.scrollY;
            model.rotation.y = 0.5 + scrollY * 0.001;
            model.position.z = scrollY * -0.005;
        }
    });


    // Handle window resize
    window.addEventListener('resize', () => {
        camera.aspect = window.innerWidth / window.innerHeight;
        camera.updateProjectionMatrix();
        renderer.setSize(window.innerWidth, window.innerHeight);
    });
}


// --- Product Viewer Scene ---
const productCanvas = document.getElementById('product-canvas');
if (productCanvas) {
    const scene = new THREE.Scene();
    const camera = new THREE.PerspectiveCamera(50, productCanvas.clientWidth / productCanvas.clientHeight, 0.1, 1000);
    camera.position.z = 10;

    const renderer = new THREE.WebGLRenderer({ canvas: productCanvas, alpha: true });
    renderer.setSize(productCanvas.clientWidth, productCanvas.clientHeight);

    // Controls
    const controls = new OrbitControls(camera, renderer.domElement);
    controls.enableDamping = true;
    controls.enableZoom = false;
    controls.autoRotate = true;
    controls.autoRotateSpeed = 2.0;

    // Lighting
    const ambientLight = new THREE.AmbientLight(0xffffff, 1.0);
    scene.add(ambientLight);
    const keyLight = new THREE.DirectionalLight(0xffffff, 1.2);
    keyLight.position.set(-5, 5, 10);
    scene.add(keyLight);
    const fillLight = new THREE.DirectionalLight(0xffffff, 0.8);
    fillLight.position.set(5, 0, 5);
    scene.add(fillLight);


    // Placeholder - replace with an actual product model
    const productGeometry = new THREE.BoxGeometry(4, 4, 4);
    const productMaterial = new THREE.MeshStandardMaterial({
        color: 0xE7E3DE, // Sand color
        metalness: 0.1,
        roughness: 0.6
    });
    const productModel = new THREE.Mesh(productGeometry, productMaterial);
    scene.add(productModel);


    // Animation Loop
    function animateProduct() {
        requestAnimationFrame(animateProduct);
        controls.update(); // for damping and auto-rotate
        renderer.render(scene, camera);
    }
    animateProduct();

    // Handle window resize
    window.addEventListener('resize', () => {
        camera.aspect = productCanvas.clientWidth / productCanvas.clientHeight;
        camera.updateProjectionMatrix();
        renderer.setSize(productCanvas.clientWidth, productCanvas.clientHeight);
    });
}
