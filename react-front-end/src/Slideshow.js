import Carousel from 'react-bootstrap/Carousel';

export default function Homepage() {
    return (
        <>
            <h3 style={{textAlign: "center"}} >Taylors Insurance Demo</h3>
            <img id="img" src="/logo.png" alt="company logo" style={{marginLeft: "44%", marginRight: "50%"}}/>
            <p style={{textAlign: "center"}}>Welcome to the product demonstration of the insurance API for taylors insurance.</p><br/>
            <h1 style={{textAlign: "center"}}>Let's meet the team!</h1>
            <Carousel variant="dark">
                <Carousel.Item>
                    <img
                        className="d-block w-100"
                        src="/JP.png"
                        alt="Second slide"
                        style={{margin: "auto"}}
                    />

                    <Carousel.Caption style={{color: 'white'}}>
                        <br/><br/>
                        <h3>Julia Parewick</h3>
                        <p>Backend Developer</p>
                    </Carousel.Caption>
                </Carousel.Item>
                <Carousel.Item>
                    <img
                        className="d-block w-100"
                        src="/AE.png"
                        alt="Third slide"
                        style={{margin: "auto"}}
                    />

                    <Carousel.Caption style={{color: 'white'}}>
                        <h3>Adam Elliott</h3>
                        <p>Backend Developer</p>
                    </Carousel.Caption>
                </Carousel.Item>
                <Carousel.Item>
                    <img
                        className="d-block w-100"
                        src="/DL.jpg"
                        alt="Fourth slide"
                        style={{margin: "auto"}}
                    />

                    <Carousel.Caption style={{color: 'red'}}>
                        <h3>Daniel Lewis</h3>
                        <p>Frontend Developer.</p>
                    </Carousel.Caption>
                </Carousel.Item>
                <Carousel.Item>
                    <img
                        className="d-block w-100"
                        src="/ms.png"
                        alt="Fifth slide"
                        style={{margin: "auto"}}
                    />

                    <Carousel.Caption style={{color: 'white'}}>
                        <h3>Mason Seward</h3>
                        <p>Frontend Developer.</p>
                    </Carousel.Caption>
                </Carousel.Item>
                <Carousel.Item>
                    <img
                        className="d-block w-100"
                        src="/logo.png"
                        alt="Sixth slide"
                        style={{margin: "auto"}}
                    />

                    <Carousel.Caption style={{color: 'white'}}>
                        <h3>Daniel Condon</h3>
                        <p>Sales And Marketing Expert.</p>
                    </Carousel.Caption>
                </Carousel.Item>
            </Carousel>
            <p id="data_display">But of course, you're here for the product :P Use the navbar on top to view the different api routes</p>
        </>
    );
}