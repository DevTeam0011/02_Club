import imgFutbol1 from '../public/imagenes/football-1275123_1280.jpg'
import imgrugby2 from '../public/imagenes/kids-56952_1280.jpg'
import imgpaddle3 from '../public/imagenes/paddle-tennis-6612340_1280.jpg'
import imgchicos4 from '../public/imagenes/hockey-3386656_1280.jpg'

const ContenedorDeImg = ({srcImg, alt}) => {
  return (
    <div className='containerImg'>
      <img src={srcImg} alt={alt} />
    </div>
  )
}

export const Galeria = () => {
  return (
    <>
      <section className='galeriaInicio'>
        <ContenedorDeImg srcImg={imgFutbol1} alt={"Futbol"} />
        <ContenedorDeImg srcImg={imgrugby2} alt={"Rugby"} />
        <ContenedorDeImg srcImg={imgpaddle3} alt={"Paddle"} />
        <ContenedorDeImg srcImg={imgchicos4} alt={"Kids"} />
      </section>
    </>
  )
}
